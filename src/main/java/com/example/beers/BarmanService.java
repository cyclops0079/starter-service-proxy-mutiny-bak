package com.example.beers;

import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

@VertxGen
@ProxyGen
public interface BarmanService {

    Future<Beer> giveMeAStaticBeer(String customerName);
    Future<Integer> getMyBill(String customerName);
    Future<Void> payMyBill(String customerName);

    static BarmanService createProxy(Vertx vertx, String address) {
        return new BarmanServiceVertxEBProxy(vertx, address);
    }

}
