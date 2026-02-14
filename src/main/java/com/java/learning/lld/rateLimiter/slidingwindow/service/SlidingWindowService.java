package com.java.learning.lld.rateLimiter.slidingwindow.service;

import com.java.learning.lld.rateLimiter.slidingwindow.dto.UserRequest;

public interface SlidingWindowService {
    public boolean isAllowed(UserRequest request);
}
