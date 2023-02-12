package com.example.beers.impl;

import com.example.beers.Beer;
import com.example.beers.BarmanService;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;

import java.util.HashMap;
import java.util.Map;

public class BarmanServiceImpl implements BarmanService {

    Map<String, Integer> bills;

    public BarmanServiceImpl() {
        this.bills = new HashMap<>();
    }

    @Override
    public void giveMeAStaticBeer(String customerName, Handler<AsyncResult<Beer>> handler) {
        Beer beer = new Beer("Workshop River Stout", "English Stout", 5);
        handler.handle(Future.succeededFuture(beer));
    }

    @Override
    public void getMyBill(String customerName, Handler<AsyncResult<Integer>> handler) {
        handler.handle(Future.succeededFuture(bills.get(customerName)));
    }

    @Override
    public void payMyBill(String customerName) {
        bills.remove(customerName);
        System.out.println("Removed debt of " + customerName);
    }
}
