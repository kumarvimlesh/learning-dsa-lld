package com.java.learning.lld.designpattern.observer;

import com.java.learning.lld.designpattern.observer.observable.Observable;
import com.java.learning.lld.designpattern.observer.observer.impl.StockPriceDisplay;
import com.java.learning.lld.designpattern.observer.observer.impl.TradingBoat;

public class ObserverDesignPattern {
    public static void main(String[] args) {
        Observable observable = new Observable();
        observable.registerObserver(new StockPriceDisplay());

        observable.updateStock("ABC", 50);

        observable.registerObserver(new TradingBoat());

        observable.updateStock("DEF", 100);
        observable.updateStock("ABC", 75);
    }
}
