package com.java.learning.lld.rateLimiter.slidingwindow;

import com.java.learning.lld.rateLimiter.slidingwindow.dto.UserRequest;
import com.java.learning.lld.rateLimiter.slidingwindow.service.SlidingWindowService;
import com.java.learning.lld.rateLimiter.slidingwindow.service.impl.SlidingWindowServiceImpl;

import java.sql.Timestamp;
import java.util.Random;
import java.util.stream.Stream;

public class SlidingWindowRateLimiter {
    public static void main(String[] args) {
        Thread thread = new Thread(new RequestThread("A"));
        Thread thread2 = new Thread(new RequestThread("B"));
        thread.start();
        thread2.start();
    }


    public static class RequestThread implements Runnable{
        private String userId;
        SlidingWindowService service = new SlidingWindowServiceImpl(10, 60);

        public RequestThread(String userId) {
            this.userId = userId;
        }

        @Override
        public void run() {
            Stream.iterate(0, i -> i + 1).limit(100).forEach(num -> {
                UserRequest request = new UserRequest(userId);
                boolean isAllowed = service.isAllowed(request);
                System.out.println(Timestamp.from(request.getTime()) + " : Request " + num + ", for user : "+request.getUserId() + " is allowed: " + isAllowed);
                try {
                    Thread.sleep(new Random().nextInt(200, 300));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
