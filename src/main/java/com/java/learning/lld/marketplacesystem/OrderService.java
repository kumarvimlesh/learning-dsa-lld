package com.java.learning.lld.marketplacesystem;


public interface OrderService {
    Order purchase(Cart cart, Payment payment);
    Order getOrder(String orderId);
    Order cancelOrder(String orderId);
}
