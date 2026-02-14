package com.java.learning.lld.diningtablebooking.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private Booking booking;
    private List<OrderItem> orderItems;

    public Order(String id, Booking booking, List<OrderItem> orderItems) {
        this.id = id;
        this.booking = booking;
        this.orderItems = orderItems;
    }

    public String getId() {
        return id;
    }

    public Booking getBooking() {
        return booking;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public List<OrderItem> addItems(List<OrderItem> orderItems){
        if(this.orderItems == null) {
            this.orderItems = new ArrayList<>();
        }
        this.orderItems.addAll(orderItems);
        return this.orderItems;
    }
}



/*
5 chapati
panner

sweets
 */