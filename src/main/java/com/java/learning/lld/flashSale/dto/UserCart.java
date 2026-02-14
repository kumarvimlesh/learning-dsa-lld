package com.java.learning.lld.flashSale.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserCart {
    private String id;
    private String userId;
    private List<CartItem> cartItems = new ArrayList<>();
    private double totalPrice;
}
