package com.java.learning.lld.ParkingLotSystem.service;

import com.java.learning.lld.ParkingLotSystem.dto.ParkingBooking;
import com.java.learning.lld.ParkingLotSystem.dto.Vehicle;

public interface ParkingSlotBookingService {
    ParkingBooking park(Vehicle vehicle);
    ParkingBooking unpark(String parkingBookingId);
}
