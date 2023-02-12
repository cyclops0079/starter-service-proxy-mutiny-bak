package com.example.beers.impl;

import com.example.beers.Beer;
import com.example.beers.BarmanService;
import io.smallrye.mutiny.Uni;

import java.util.HashMap;
import java.util.Map;

public class BarmanServiceImpl implements BarmanService {

    Map<String, Integer> bills;

    public BarmanServiceImpl() {
        this.bills = new HashMap<>();
    }

    @Override
    public Uni<Beer> giveMeAStaticBeer(String customerName) {
        Beer beer = new Beer("Workshop River Stout", "English Stout", 5);
        return Uni.createFrom().item(() -> beer);
    }

    @Override
    public Uni<Integer> getMyBill(String customerName) {
        return Uni.createFrom().item(() -> bills.get(customerName));
    }

    @Override
    public Uni<Void> payMyBill(String customerName) {
        bills.remove(customerName);
        System.out.println("Removed debt of " + customerName);
        return Uni.createFrom().voidItem();
    }
}
