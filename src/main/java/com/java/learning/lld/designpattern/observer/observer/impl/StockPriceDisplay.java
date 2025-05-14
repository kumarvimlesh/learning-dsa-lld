package com.java.learning.lld.designpattern.observer.observer.impl;

import com.java.learning.lld.designpattern.observer.observer.StockPriceObserver;

public class StockPriceDisplay implements StockPriceObserver {

    @Override
    public void observe(String stockName, int stockPrice) {
        System.out.println("[StockPriceDisplay] :: stockName : " + stockName + ",  stockPrice : " + stockPrice);
    }
}
