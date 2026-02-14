package com.java.learning.lld.ParkingLotSystem.service;

import com.java.learning.lld.ParkingLotSystem.dto.ParkingBooking;

public interface PricingService {
    public double calculatePrice(ParkingBooking parkingBooking);

}
