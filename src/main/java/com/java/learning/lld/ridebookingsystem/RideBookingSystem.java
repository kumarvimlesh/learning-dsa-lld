package com.java.learning.lld.ridebookingsystem;

import javax.xml.stream.Location;
import java.util.List;

public class RideBookingSystem {
    public static void main(String[] args){
    }
}

class Vehicle{
    String id;
    String userId;
}

enum CarCategory{
    SUV, XUV
}

class Car extends Vehicle{
    private CarCategory category;
}

class Bike extends Vehicle{

}

class Auto extends Vehicle{

}

class User{
    private String id;
    private String name;
    private String mobile;
}

class Driver extends User{
    private Vehicle vehicle;
}

class Rider extends User{

}

enum RideStatus{
    Booked, Confirmed, Cancelled, Completed
}

class Ride{
    private String id;
    private String userId;
    private Vehicle vehicle;
    private RideStatus rideStatus;
    private Location source;
    private Location destination;
}

interface RideService{
    Ride request(Rider rider, Location source, Location destination, String type);

    List<Driver> findNearestDriver(Location location, String type);

    Ride confirmRide(Driver driver);

    Ride sendConfirmationToUser();
    Ride startRide(String otp);
}


