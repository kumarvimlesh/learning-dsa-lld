package com.java.learning.lld.rateLimiter.slidingwindow.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class UserRequest {
    private String userId;
    private Instant time = Instant.now();

    public UserRequest(String userId) {
        this.userId = userId;
    }
}
