package com.java.learning.lld.designpattern.strategy;

//Needs good drive capability
public class Compact extends Vehicle{
    public Compact(String id, String registrationNumber, int capacity, DriveStrategy driveStrategy) {
        super(id, registrationNumber, capacity, driveStrategy);
    }
}
