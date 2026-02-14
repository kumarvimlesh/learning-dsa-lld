package com.java.learning.lld.ParkingLotSystem.dto;

import com.java.learning.lld.ParkingLotSystem.enums.ParkingSlotType;
import lombok.Data;

@Data
public class ParkingSlot {
    private String id;
    private ParkingSlotType parkingSlotType;
    private boolean available;
}
