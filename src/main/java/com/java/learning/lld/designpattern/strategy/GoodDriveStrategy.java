package com.java.learning.lld.designpattern.strategy;

public class GoodDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Good drive strategy");
    }
}
