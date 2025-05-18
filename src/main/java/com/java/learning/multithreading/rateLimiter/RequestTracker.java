package com.java.learning.multithreading.rateLimiter;

import lombok.Data;

@Data
public class RequestTracker {
    private long second;
    private int count;

    public RequestTracker(long second) {
        this.second = second;
        this.count = 0;
    }
}
