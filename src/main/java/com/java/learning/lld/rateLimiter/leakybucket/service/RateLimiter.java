package com.java.learning.lld.rateLimiter.leakybucket.service;

import com.java.learning.lld.rateLimiter.leakybucket.dto.Request;

public interface RateLimiter {
    boolean isAllowed(Request request);
}
