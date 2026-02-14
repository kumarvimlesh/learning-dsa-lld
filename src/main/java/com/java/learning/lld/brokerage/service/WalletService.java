package com.java.learning.lld.brokerage.service;


import com.java.learning.lld.brokerage.enums.BalanceUpdateType;

public interface WalletService {
    public void addBalance(BalanceUpdateType balanceUpdateType, String userId, double balance);
}
