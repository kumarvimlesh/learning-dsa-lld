package com.java.learning.lld.ParkingLotSystem.repository;


import com.java.learning.lld.ParkingLotSystem.dto.ParkingBooking;

import java.util.HashMap;
import java.util.Map;

public class ParkingBookingRepository {
    private static volatile ParkingBookingRepository instance;
    private final Map<String, ParkingBooking> parkingBookings;

    private ParkingBookingRepository(){
        parkingBookings = new HashMap<>();
    }

    public static ParkingBookingRepository getInstance(){
        if (instance==null){
            synchronized (ParkingBookingRepository.class){
                if (instance==null){
                    instance = new ParkingBookingRepository();
                }
            }
        }
        return instance;
    }

    public ParkingBooking findById(String id){
        return parkingBookings.getOrDefault(id, null);
    }

    public ParkingBooking save(ParkingBooking parkingBooking){
        return parkingBookings.put(parkingBooking.getId(), parkingBooking);
    }
}
