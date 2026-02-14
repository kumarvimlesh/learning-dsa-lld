package com.java.learning.lld.ParkingLotSystem.dto;

import com.java.learning.lld.ParkingLotSystem.enums.ParkingBookingStatus;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class ParkingBooking {
    private String id;
    private String parkingSlotId;
    private String vehicleId;
    private Instant entryTime;
    private Instant exitTime;
    private double amount;
    private ParkingBookingStatus status;
}
