package com.java.learning.lld.brokerage.dto;


import com.java.learning.lld.brokerage.enums.OrderStatus;

import java.time.LocalDateTime;

public class Order {
    private String id;
    private String userId;
    private String stockId;
    private long quantity;
    private double totalAmount;
    private OrderStatus orderStatus;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Order(String id, String userId, String stockId, long quantity, double totalAmount, OrderStatus orderStatus) {
        this.id = id;
        this.userId = userId;
        this.stockId = stockId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
    }
}
