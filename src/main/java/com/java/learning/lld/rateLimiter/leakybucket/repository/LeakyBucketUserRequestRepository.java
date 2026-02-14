package com.java.learning.lld.rateLimiter.leakybucket.repository;

import com.java.learning.lld.rateLimiter.leakybucket.dto.UserBucketStatus;
import java.util.concurrent.ConcurrentHashMap;

public class LeakyBucketUserRequestRepository {
    private final ConcurrentHashMap<String, UserBucketStatus> userBucket;
    private static LeakyBucketUserRequestRepository instance;

    private LeakyBucketUserRequestRepository() {
        this.userBucket = new ConcurrentHashMap<>();
    }

    public static LeakyBucketUserRequestRepository getInstance() {
        if (instance == null) {
            instance = new LeakyBucketUserRequestRepository();
        }
        return instance;
    }

    public UserBucketStatus findByUserId(String userId) {
        return userBucket.getOrDefault(userId, null);
    }

    public void saveAll(String userId, UserBucketStatus bucketStatus) {
        userBucket.put(userId, bucketStatus);
    }
}
