package com.java.learning.lld.foodDeliverySystem.service;


import com.java.learning.lld.foodDeliverySystem.dto.Cart;
import com.java.learning.lld.foodDeliverySystem.dto.FoodMenu;

public interface CartService {
    Cart addToCart(FoodMenu foodMenu, String userId);
    Cart removeFromCart(FoodMenu foodMenu, String userId);
}
