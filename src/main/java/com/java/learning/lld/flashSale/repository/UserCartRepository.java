package com.java.learning.lld.flashSale.repository;

import com.java.learning.lld.flashSale.dto.UserCart;

import java.util.HashMap;
import java.util.Map;

public class UserCartRepository {
    private final Map<String, UserCart> userCartMap = new HashMap<>();
    private static UserCartRepository instance = new UserCartRepository();

    private UserCartRepository(){};

    public static UserCartRepository getInstance(){
        if (instance == null)
            instance = new UserCartRepository();
        return instance;
    }

    public UserCart findByUserId(String userId) {
        return userCartMap.get(userId);
    }

    public UserCart save(UserCart userCart) {
        userCartMap.put(userCart.getUserId(), userCart);
        return userCart;
    }
}
