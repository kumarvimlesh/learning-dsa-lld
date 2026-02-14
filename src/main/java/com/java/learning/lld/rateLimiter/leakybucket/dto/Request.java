package com.java.learning.lld.rateLimiter.leakybucket.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class Request {
    private String userId;
    private Instant timestamp = Instant.now();

    public Request(String userId) {
        this.userId = userId;
    }
}
