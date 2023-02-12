package com.example;

import com.example.beers.BarmanService;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class DrunkVerticle extends AbstractVerticle {

    @Override
    public void start(Promise<Void> startPromise) {
        BarmanService barmanService = BarmanService.createProxy(vertx, "beers.services.myapplication");

        System.out.println("The barman is ready to serve you");
        barmanService.giveMeAStaticBeer("homer", b1 -> {
            if (b1.failed()) {
                System.err.println("Cannot get my first beer!");
                startPromise.fail(b1.cause());
                return;
            }
            System.out.println("My beer is a " + b1.result() + " and it costs " + b1.result().getPrice() + "€");
            vertx.setTimer(10, l -> {
                barmanService.getMyBill("homer", billAr -> {
                    System.out.println("My bill with the bar is " + billAr.result());
                    barmanService.payMyBill("homer");
                    startPromise.complete();
                });
            });
        });

    }

}
