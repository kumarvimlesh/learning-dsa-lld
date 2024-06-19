package com.java.learning.lld.marketplacesystem;

import org.apache.catalina.User;

import java.util.UUID;

public class Payment {
    private UUID id;
    private PaymentMode pymentMode;
    private PaymentStatus paymentStatus;
    private double amount;
    private User user;
}
