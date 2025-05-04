package com.java.learning.lld.designpattern.strategy;

public class StrategyDesignPattern {
    public static void main(String[] args) {
        System.out.println("Bike : ");
        Bike bike = new Bike("1", "AB2345", 2, new NormalDriveStrategy());
        bike.getDriveStrategy().drive();

        System.out.println("Compact : ");
        Compact compact = new Compact("2", "CD2345", 6, new GoodDriveStrategy());
        compact.getDriveStrategy().drive();

        System.out.println("Large : ");
        Large large = new Large("3", "GE2389", 15, new GoodDriveStrategy());
        large.getDriveStrategy().drive();
    }
}
