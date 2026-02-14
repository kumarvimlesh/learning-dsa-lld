package com.java.learning.lld.ParkingLotSystem.service.impl;

import com.java.learning.lld.ParkingLotSystem.dto.ParkingBooking;
import com.java.learning.lld.ParkingLotSystem.dto.ParkingSlot;
import com.java.learning.lld.ParkingLotSystem.dto.Vehicle;
import com.java.learning.lld.ParkingLotSystem.enums.ParkingBookingStatus;
import com.java.learning.lld.ParkingLotSystem.enums.ParkingSlotType;
import com.java.learning.lld.ParkingLotSystem.enums.VehicleCategory;
import com.java.learning.lld.ParkingLotSystem.repository.ParkingBookingRepository;
import com.java.learning.lld.ParkingLotSystem.repository.ParkingSlotRepository;
import com.java.learning.lld.ParkingLotSystem.service.ParkingSlotBookingService;
import com.java.learning.lld.ParkingLotSystem.service.PricingService;

import java.time.Instant;
import java.util.UUID;

public class ParkingSlotBookingServiceImpl implements ParkingSlotBookingService {
    private final ParkingSlotRepository parkingSlotRepository;
    private final ParkingBookingRepository parkingBookingRepository;
    private final PricingService pricingService;

    public ParkingSlotBookingServiceImpl(ParkingSlotRepository parkingSlotRepository, ParkingBookingRepository parkingBookingRepository, PricingService pricingService) {
        this.parkingSlotRepository = parkingSlotRepository;
        this.parkingBookingRepository = parkingBookingRepository;
        this.pricingService = pricingService;
    }


    @Override
    public synchronized ParkingBooking park(Vehicle vehicle) {
        ParkingSlotType requiredParkingSlot = deriveRequiredParkingSlotType(vehicle.getVehicleCategory());
        ParkingSlot availableParkingSlot = parkingSlotRepository.findAvailableByParkingSlotType(requiredParkingSlot);
        ParkingBooking parkingBooking = ParkingBooking.builder()
                .parkingSlotId(availableParkingSlot.getId())
                .id(UUID.randomUUID().toString())
                .entryTime(Instant.now())
                .status(ParkingBookingStatus.ACTIVE)
                .vehicleId(vehicle.getId())
                .build();
        availableParkingSlot.setAvailable(false);
        parkingSlotRepository.save(availableParkingSlot);
        return parkingBookingRepository.save(parkingBooking);
    }

    private ParkingSlotType deriveRequiredParkingSlotType(VehicleCategory vehicleCategory) {
        switch (vehicleCategory){
            case LARGE -> {
                return ParkingSlotType.LARGE;
            }
            case SMALL -> {
                return ParkingSlotType.SMALL;
            }
            case MEDIUM -> {
                return ParkingSlotType.MEDIUM;
            }
            case MEDIUM_LARGE -> {
                return ParkingSlotType.MEDIUM_LARGE;
            }
            default -> {
                return null;
            }
        }
    }

    @Override
    public ParkingBooking unpark(String parkingBookingId) {
        ParkingBooking parkingBooking = parkingBookingRepository.findById(parkingBookingId);
        parkingBooking.setExitTime(Instant.now());
        double price = pricingService.calculatePrice(parkingBooking);
        parkingBooking.setAmount(price);
        //deduct payment async
        parkingBooking.setStatus(ParkingBookingStatus.COMPLETED);
        ParkingSlot parkingSlot = parkingSlotRepository.findById(parkingBooking.getParkingSlotId());
        parkingSlot.setAvailable(true);
        parkingSlotRepository.save(parkingSlot);
        return parkingBooking;
    }
}
