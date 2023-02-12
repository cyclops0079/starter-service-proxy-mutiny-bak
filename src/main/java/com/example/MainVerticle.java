package com.example;

import com.example.beers.BarmanService;
import com.example.beers.impl.BarmanServiceImpl;
import io.vertx.core.AbstractVerticle;
import io.vertx.serviceproxy.ServiceBinder;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() {
        new ServiceBinder(vertx)
            .setAddress("beers.services.myapplication")
            .register(BarmanService.class, new BarmanServiceImpl());

        vertx.deployVerticle(new DrunkVerticle(), ar2 -> vertx.close());
    }

}
