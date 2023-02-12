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
    public Future<Beer>  giveMeAStaticBeer(String customerName) {
        Beer beer = new Beer("Workshop River Stout", "English Stout", 5);
        return Future.succeededFuture(beer);
    }

    @Override
    public Future<Integer> getMyBill(String customerName) {
        return Future.succeededFuture(bills.get(customerName));
    }

    @Override
    public Future<Void> payMyBill(String customerName) {
        bills.remove(customerName);
        System.out.println("Removed debt of " + customerName);
        return Future.succeededFuture();
    }
}
