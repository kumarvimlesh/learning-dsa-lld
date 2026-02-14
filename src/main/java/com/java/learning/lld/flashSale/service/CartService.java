package com.java.learning.lld.flashSale.service;

import com.java.learning.lld.flashSale.dto.UserCart;
import com.java.learning.lld.flashSale.dto.CartItem;
import com.java.learning.lld.flashSale.repository.UserCartRepository;

import java.util.UUID;

public class CartService {
    private final UserCartRepository userCartRepository;

    public CartService(UserCartRepository userCartRepository) {
        this.userCartRepository = UserCartRepository.getInstance();
    }

    public UserCart addToCart(CartItem cartItem, String userId){
        UserCart userCart = userCartRepository.findByUserId(userId);
        if (userCart == null){
            userCart = new UserCart();
            userCart.setId(UUID.randomUUID().toString());
            userCart.setUserId(userId);
        }
        userCart.getCartItems().add(cartItem);
        return userCartRepository.save(userCart);
    }
}
