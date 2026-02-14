package com.java.learning.lld.foodDeliverySystem.service;

import com.java.learning.lld.foodDeliverySystem.dto.Order;

public interface PricingService {
    double calculatePrice(Order orderDetails);
}
