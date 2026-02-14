package com.java.learning.lld.brokerage.service;

import com.java.learning.lld.brokerage.dto.Order;
import com.java.learning.lld.brokerage.dto.Stock;
import com.java.learning.lld.brokerage.dto.UserDto;
import com.java.learning.lld.brokerage.enums.BalanceUpdateType;
import com.java.learning.lld.brokerage.enums.OrderStatus;
import jakarta.transaction.Transactional;

public class OrderService {
    //repositories
    //Wallet service
    BrokerageService brokerageService;

    WalletService walletService;
    //redis

    @Transactional
    public com.java.learning.lld.brokerage.dto.Order placeBuyOrder(String userId, String stockId, long quantity, double price){
        //fetch user
        UserDto user = new UserDto();
        Stock stock; //fetch from db a

        Order order = new Order("123", userId, stockId, quantity, price, OrderStatus.PENDING);
        //Save in database

        walletService.addBalance(BalanceUpdateType.WITHDRAWAL, userId, price);

        ///redisServcie,put(order, ttl); redis/scheduler

        brokerageService.buy(order);
        //retry
        return order;

    }



/**
 *
    webhook()


    checkStatusAndTakeAction(){
        //if failed -> revert
        //complete -> deduct hild
    }

    **///

}
