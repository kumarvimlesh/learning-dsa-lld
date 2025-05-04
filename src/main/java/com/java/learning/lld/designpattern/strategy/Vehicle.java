package com.java.learning.lld.designpattern.strategy;

import lombok.Data;

@Data
public class Vehicle {
    private String id;
    private String registrationNumber;
    private int capacity;
    private DriveStrategy driveStrategy;

    public Vehicle(String id, String registrationNumber, int capacity, DriveStrategy driveStrategy) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.capacity = capacity;
        this.driveStrategy = driveStrategy;
    }
}
