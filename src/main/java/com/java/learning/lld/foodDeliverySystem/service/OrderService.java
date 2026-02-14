package com.java.learning.lld.foodDeliverySystem.service;


import com.java.learning.lld.foodDeliverySystem.dto.Address;
import com.java.learning.lld.foodDeliverySystem.dto.Order;

public interface OrderService {
    Order placeOrder(Order orderDetails, Address deliveryAddress, String userId);
}
