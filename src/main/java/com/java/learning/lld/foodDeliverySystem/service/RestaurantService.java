package com.java.learning.lld.foodDeliverySystem.service;

import com.java.learning.lld.foodDeliverySystem.dto.Order;
import com.java.learning.lld.foodDeliverySystem.dto.Restaurant;

import java.util.List;
import java.util.Map;

public interface RestaurantService {
    Restaurant addRestaurant(Restaurant restaurant);
    Restaurant updateRestaurant(Restaurant restaurant, String restaurantId);
    Restaurant getRestaurant(String restaurantId);
    List<Restaurant> getRestaurants(Map<String, String> searchParams);

    void sendOrderAcceptanceRequest(Order orderDetails);
    void confirmOrder(String orderId, boolean isAccepted);
}
