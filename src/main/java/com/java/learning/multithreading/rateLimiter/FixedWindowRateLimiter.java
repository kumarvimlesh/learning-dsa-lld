package com.java.learning.multithreading.rateLimiter;

import java.util.HashMap;
import java.util.Map;

public class FixedWindowRateLimiter implements RateLimiter{
    private final int maxRequestPerUser;
    private final Map<String, RequestTracker> userRequestMap;

    public FixedWindowRateLimiter(int maxRequestPerUser) {
        this.maxRequestPerUser = maxRequestPerUser;
        this.userRequestMap = new HashMap<>();
    }

    @Override
    public boolean allowRequest(String userId) {
        long currentSecond = System.currentTimeMillis() / 1000;
        userRequestMap.putIfAbsent(userId, new RequestTracker(currentSecond));
        RequestTracker requestTracker = userRequestMap.get(userId);
        synchronized (requestTracker){
            if (requestTracker.getSecond() != currentSecond){
                requestTracker.setSecond(currentSecond);
                requestTracker.setCount(1);
                return true;
            }
            else {
                if (requestTracker.getCount() +  1 > this.maxRequestPerUser){
                    return false;
                }
                else {
                    requestTracker.setCount(requestTracker.getCount() + 1);
                    return true;
                }
            }
        }
    }
}
