package com.java.learning.lld.designpattern.observer.observer;

public interface StockPriceObserver {
    void observe(String stockName, int stockPrice);
}
