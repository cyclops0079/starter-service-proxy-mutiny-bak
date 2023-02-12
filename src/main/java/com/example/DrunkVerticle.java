package com.example;

import com.example.mutiny.beers.BarmanService;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class DrunkVerticle extends AbstractVerticle {

    @Override
    public void start(Promise<Void> startPromise) {
        io.vertx.mutiny.core.Vertx mutinyVertx = new io.vertx.mutiny.core.Vertx(vertx);
        BarmanService barmanService = BarmanService.createProxy(mutinyVertx, "beers.services.myapplication");

        System.out.println("The barman is ready to serve you");
        barmanService.giveMeAStaticBeer("homer")
            .onFailure().recoverWithItem(f -> {
                System.err.println("Cannot get my first beer!");
                startPromise.fail(f.getCause());
                return null;
            })
            .invoke(b -> {
                System.out.println("My beer is a " + b + " and it costs " + b.getPrice() + "€");
                mutinyVertx.setTimer(10, l -> {
                    barmanService.getMyBill("homer")
                        .invoke(bill -> {
                            System.out.println("My bill with the bar is " + bill);
                            barmanService.payMyBill("homer");
                            startPromise.complete();
                        })
                        .subscribe().asCompletionStage();
                });
            })
            .subscribe().asCompletionStage();

    }

}
