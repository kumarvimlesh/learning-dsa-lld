package com.java.learning.lld.rateLimiter.slidingwindow.service.impl;

import com.java.learning.lld.rateLimiter.slidingwindow.dto.UserRequest;
import com.java.learning.lld.rateLimiter.slidingwindow.repository.UserRequestRepository;
import com.java.learning.lld.rateLimiter.slidingwindow.service.SlidingWindowService;

import java.util.PriorityQueue;

public class SlidingWindowServiceImpl implements SlidingWindowService {
    private final UserRequestRepository userRequestRepository;
    private final long MAX_LIMIT;
    private final long INTERVAL; //in seconds

    public SlidingWindowServiceImpl(long maxLimit, long interval) {
        this.userRequestRepository = UserRequestRepository.getInstance();
        this.MAX_LIMIT = maxLimit;
        this.INTERVAL = interval;
    }

    @Override
    public boolean isAllowed(UserRequest request) {
        PriorityQueue<UserRequest> userRequests = userRequestRepository.findUserRequestsByUserId(request.getUserId());
        while (!userRequests.isEmpty() && ((request.getTime().toEpochMilli() - userRequests.peek().getTime().toEpochMilli())/1000)>INTERVAL){
            userRequests.poll();
        }
        boolean isAllowed;
        if (userRequests.size()>=MAX_LIMIT) isAllowed =  false;
        else {
            userRequests.add(request);
            isAllowed = true;
        }
        userRequestRepository.save(request.getUserId(), userRequests);
        return isAllowed;
    }
}
