package com.java.learning.lld.ParkingLotSystem.repository;

import com.java.learning.lld.ParkingLotSystem.dto.ParkingSlot;
import com.java.learning.lld.ParkingLotSystem.enums.ParkingSlotType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingSlotRepository {
    private static volatile ParkingSlotRepository instance;
    private final List<ParkingSlot> availableParkingSlots;
    private final Map<String, ParkingSlot> parkingSlotMap;

    private ParkingSlotRepository(){
        this.parkingSlotMap = new HashMap<>();
        availableParkingSlots = new ArrayList<>();
    }

    public static ParkingSlotRepository getInstance(){
        if (instance==null){
            synchronized (ParkingSlotRepository.class){
                if (instance==null){
                    instance = new ParkingSlotRepository();
                }
            }
        }
        return instance;
    }

    public ParkingSlot findAvailableByParkingSlotType(ParkingSlotType parkingSlotType){
        return availableParkingSlots.stream()
                .filter(parkingSlot -> parkingSlot.isAvailable() && parkingSlotType.equals(parkingSlot.getParkingSlotType()))
                .findFirst()
                .orElse(null);
    }

    public ParkingSlot findById(String parkingSlotId) {
        return parkingSlotMap.getOrDefault(parkingSlotId, null);
    }

    public ParkingSlot save(ParkingSlot parkingSlot) {
        parkingSlotMap.put(parkingSlot.getId(), parkingSlot);
        if (parkingSlot.isAvailable())
            availableParkingSlots.add(parkingSlot);
        else availableParkingSlots.removeIf(ps -> ps.getId().equals(parkingSlot.getId()));
        return parkingSlot;
    }
}
