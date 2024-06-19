package com.java.learning.lld.marketplacesystem;

import org.apache.catalina.User;

import java.util.List;
import java.util.UUID;

public class Order {
    private UUID id;
    private User user;
    private List<Product> products;
    private Payment payment;
}
