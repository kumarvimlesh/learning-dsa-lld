package com.java.learning.lld.diningtablebooking.service;


import com.java.learning.lld.diningtablebooking.entity.Booking;
import com.java.learning.lld.diningtablebooking.entity.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BookingService {
    private final List<Table> tables;
    private final Map<String, Booking> bookingMap = new HashMap<>();

    public BookingService(List<Table> tables) {
        this.tables = tables;
    }

    public BookingService() {
        this.tables = new ArrayList<>();
    }

    public Booking bookTable(int n){
        for(Table table : tables){
            if(table.getCapacity() >= n && table.isAvailable()){
                table.setAvailable(false);
                Booking booking = new Booking(UUID.randomUUID().toString(), n, table);
                bookingMap.put(booking.getId(),booking);
                return booking;
            }
        }
        throw new RuntimeException("No table is available");
    }

    public Booking getBooking(String bookingId){
        return bookingMap.get(bookingId);
    }

    public void addTable(Table table) {
        this.tables.add(table);
    }
}
