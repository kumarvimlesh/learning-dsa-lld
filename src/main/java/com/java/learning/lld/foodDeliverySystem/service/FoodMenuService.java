package com.java.learning.lld.foodDeliverySystem.service;

import com.java.learning.lld.foodDeliverySystem.dto.FoodMenu;

import java.util.List;
import java.util.Map;

public interface FoodMenuService {
    FoodMenu addFoodMenu(FoodMenu foodMenu);
    FoodMenu updateFoodMenu(FoodMenu foodMenu, String menuId);
    FoodMenu getFoodMenu(String menuId);
    List<FoodMenu> getFoodMenu(Map<String, String> searParams); //Params: restaurantName, menuName etc.
}
