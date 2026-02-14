package com.java.learning.lld.ParkingLotSystem.dto;

import com.java.learning.lld.ParkingLotSystem.enums.VehicleCategory;
import lombok.Data;

@Data
public class Vehicle {
    private String id;
    private String registrationNumber;
    private VehicleCategory vehicleCategory;
}
