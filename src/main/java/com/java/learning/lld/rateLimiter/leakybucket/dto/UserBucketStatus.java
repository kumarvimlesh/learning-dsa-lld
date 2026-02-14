package com.java.learning.lld.rateLimiter.leakybucket.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class UserBucketStatus {
    private String userId;
    private long currentHolding;
    private Instant lastRefillTime;
}
