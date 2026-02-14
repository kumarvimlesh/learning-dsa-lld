package com.java.learning.lld.foodDeliverySystem.service.impl;

import com.java.learning.lld.foodDeliverySystem.dto.Address;
import com.java.learning.lld.foodDeliverySystem.dto.Order;
import com.java.learning.lld.foodDeliverySystem.enums.OrderStatus;
import com.java.learning.lld.foodDeliverySystem.enums.RedisManager;
import com.java.learning.lld.foodDeliverySystem.messages.Publisher;
import com.java.learning.lld.foodDeliverySystem.repository.OrderRepository;
import com.java.learning.lld.foodDeliverySystem.service.OrderService;
import com.java.learning.lld.foodDeliverySystem.service.PaymentService;
import com.java.learning.lld.foodDeliverySystem.service.PricingService;

public class OrderServiceImpl implements OrderService {
    private final PricingService pricingService;
    private final PaymentService paymentService;

    private final OrderRepository orderRepository;

    private final Publisher publisher;
    private final RedisManager<String, Order> redisManager;

    public OrderServiceImpl(PricingService pricingService, PaymentService paymentService, OrderRepository orderRepository,
                            Publisher publisher, RedisManager redisManager) {
        this.pricingService = pricingService;
        this.paymentService = paymentService;
        this.orderRepository = orderRepository;
        this.publisher = publisher;
        this.redisManager = redisManager;
    }


    @Override
    public Order placeOrder(Order orderDetails, Address deliveryAddress, String userId) {
        orderDetails.setDeliveryAddress(deliveryAddress);
        orderDetails.setUserId(userId);
        double totalPrice = pricingService.calculatePrice(orderDetails);
        /// match the price and reject the order if there is any mismatch
        orderDetails.setAmount(totalPrice);
        orderDetails.setOrderStatus(OrderStatus.INITIATED);
        orderRepository.save(orderDetails);
        paymentService.initiatePayment(totalPrice, orderDetails.getPaymentDetails());
        redisManager.put(orderDetails.getId(), orderDetails);
        publisher.publish(orderDetails);
        return orderDetails;
    }
}
