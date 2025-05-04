package com.java.learning.lld.designpattern.strategy;

//Needs good drive capability
public class Large extends Vehicle{
    public Large(String id, String registrationNumber, int capacity, DriveStrategy driveStrategy) {
        super(id, registrationNumber, capacity, driveStrategy);
    }
}
