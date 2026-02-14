package com.java.learning.lld.rateLimiter.fixedwindow;

public interface RateLimiter {
    boolean allowRequest(String userId);
}
