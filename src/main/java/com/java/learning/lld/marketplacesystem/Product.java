package com.java.learning.lld.marketplacesystem;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
class Product {
    private UUID id;
    private String name;
    private Double price;
    private String description;
    private Seller seller;
    private Integer quantity;
}
