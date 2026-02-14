package com.java.learning.lld.rateLimiter.slidingwindow.repository;

import com.java.learning.lld.rateLimiter.slidingwindow.dto.UserRequest;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

public class UserRequestRepository {
    private final Map<String, PriorityQueue<UserRequest>> userRequestMap;
    private static UserRequestRepository instance;

    private UserRequestRepository(){
        userRequestMap = new ConcurrentHashMap<>();
    };

    public static synchronized UserRequestRepository getInstance(){
        if (instance == null){
            instance = new UserRequestRepository();
        }
        return instance;
    }

    public PriorityQueue<UserRequest> findUserRequestsByUserId(String userId){
        return userRequestMap.getOrDefault(userId, new PriorityQueue<>(Comparator.comparing(UserRequest::getTime)));
    }


    public void save(String userId, PriorityQueue<UserRequest> userRequests) {
        userRequestMap.put(userId, userRequests);
    }
}
