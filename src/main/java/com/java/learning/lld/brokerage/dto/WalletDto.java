package com.java.learning.lld.brokerage.dto;

import java.util.List;

public class WalletDto {
    private String id;
    private String userId;
    private double availableBalance;
    private List<WalletTransaction> walletTransactions;
}
