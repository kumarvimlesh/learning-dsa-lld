package com.java.learning.lld.designpattern.observer.observer.impl;

import com.java.learning.lld.designpattern.observer.observer.StockPriceObserver;

public class TradingBoat implements StockPriceObserver {
    @Override
    public void observe(String stockName, int stockPrice) {
        System.out.println("[TradingBoat] :: stockName : " + stockName + ",  stockPrice : " + stockPrice);
    }
}
