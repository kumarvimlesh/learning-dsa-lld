package com.java.learning.lld.designpattern.strategy;

//Needs normal drive capability
public class Bike extends Vehicle{
    public Bike(String id, String registrationNumber, int capacity, DriveStrategy driveStrategy) {
        super(id, registrationNumber, capacity, driveStrategy);
    }
}
