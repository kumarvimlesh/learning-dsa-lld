package com.java.learning.lld.diningtablebooking.service;


import com.java.learning.lld.diningtablebooking.entity.Booking;
import com.java.learning.lld.diningtablebooking.entity.Order;
import com.java.learning.lld.diningtablebooking.entity.OrderItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class OrderService {
    private final Map<String, Order> orders = new HashMap<>();

    public Order creatOrder(Booking booking, List<OrderItem> orderItems){
        Order order = new Order(UUID.randomUUID().toString(), booking, orderItems);
        orders.put(order.getId(), order);
        return order;
    }

    public Order fetchOrder(String orderId) {
        return orders.get(orderId);
    }
}

