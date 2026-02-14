package com.java.learning.lld.foodDeliverySystem.messages;

import com.java.learning.lld.foodDeliverySystem.dto.Order;
import com.java.learning.lld.foodDeliverySystem.service.NotificationService;
import com.java.learning.lld.foodDeliverySystem.service.RestaurantService;

public class Consumer {
    private final RestaurantService restaurantService;
    public final NotificationService notificationService;

    public Consumer(RestaurantService restaurantService, NotificationService notificationService) {
        this.restaurantService = restaurantService;
        this.notificationService = notificationService;
    }

    void orderInitiatedEvent(Object orderInitiatedEvent){

    }

    void orderAcceptedEvent(Order orderAcceptedEvent){
        //send acceptance request to the restaurants
        restaurantService.sendOrderAcceptanceRequest((Order) orderAcceptedEvent);
    }

    void orderConfirmedEvent(Object orderInitiatedEvent){
        //
        notificationService.notify(orderInitiatedEvent);
    }
}
