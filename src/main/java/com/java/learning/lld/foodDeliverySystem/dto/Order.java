package com.java.learning.lld.foodDeliverySystem.dto;

import com.java.learning.lld.foodDeliverySystem.enums.OrderStatus;
import lombok.Data;

import java.util.List;

@Data
public class Order {
    private String id;
    private String userId;
    private List<FoodMenu> orderItems;
    private double amount;
    private Address deliveryAddress;
    private OrderStatus orderStatus;
    private PaymentDetails paymentDetails;
}
