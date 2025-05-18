package com.java.learning.multithreading.rateLimiter;

public interface RateLimiter {
    boolean allowRequest(String userId);
}
