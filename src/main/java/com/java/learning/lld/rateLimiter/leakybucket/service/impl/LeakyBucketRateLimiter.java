package com.java.learning.lld.rateLimiter.leakybucket.service.impl;

import com.java.learning.lld.rateLimiter.leakybucket.dto.UserBucketStatus;
import com.java.learning.lld.rateLimiter.leakybucket.dto.Request;
import com.java.learning.lld.rateLimiter.leakybucket.repository.LeakyBucketUserRequestRepository;
import com.java.learning.lld.rateLimiter.leakybucket.service.RateLimiter;

import java.util.Objects;

public class LeakyBucketRateLimiter implements RateLimiter {
    private LeakyBucketUserRequestRepository userRequestRepository;
    private long allowedRequestRate; //per second
    private long maxCapacity;

    public LeakyBucketRateLimiter(long allowedRequestRate, long maxCapacity) {
        this.allowedRequestRate = allowedRequestRate;
        this.maxCapacity = maxCapacity;
        this.userRequestRepository = LeakyBucketUserRequestRepository.getInstance();
    }


    @Override
    public boolean isAllowed(Request request) {
        UserBucketStatus userBucketStatus = userRequestRepository.findByUserId(request.getUserId());
        long remaining;
        if (Objects.isNull(userBucketStatus)) {
            userBucketStatus = new UserBucketStatus();
            userBucketStatus.setUserId(request.getUserId());
            remaining = 0;
        }
        else{
            long timePassed = (request.getTimestamp().toEpochMilli() - userBucketStatus.getLastRefillTime().toEpochMilli())/1000;
            long processed = timePassed * allowedRequestRate;
            remaining = userBucketStatus.getCurrentHolding() - processed;
            if (remaining < 0) remaining = 0;
        }
        System.out.println("remaining : " + remaining);
        if (remaining >= maxCapacity) return false;
        userBucketStatus.setCurrentHolding(remaining + 1);
        userBucketStatus.setLastRefillTime(request.getTimestamp());
        userRequestRepository.saveAll(request.getUserId(), userBucketStatus);
        return true;
    }
}
