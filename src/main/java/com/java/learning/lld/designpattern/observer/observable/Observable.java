package com.java.learning.lld.designpattern.observer.observable;

import com.java.learning.lld.designpattern.observer.observer.StockPriceObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Observable {
    private Map<String, Integer> stockPriceMap = new HashMap<>();
    private List<StockPriceObserver> stockPriceObservers = new ArrayList<>();

    public void registerObserver(StockPriceObserver stockPriceObserver){
        this.stockPriceObservers.add(stockPriceObserver);
    }

    public void unRegisterObserver(StockPriceObserver stockPriceObserver){
        this.stockPriceObservers.remove(stockPriceObserver);
    }

    public void updateStock(String stockName, int stockPrice){
        this.stockPriceMap.put(stockName, stockPrice);
        notifyObservers(stockName, stockPrice);
    }

    private void notifyObservers(String stockName, int stockPrice) {
        stockPriceObservers.forEach(stockPriceObserver -> stockPriceObserver.observe(stockName, stockPrice));
    }
}
