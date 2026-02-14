package com.java.learning.lld.rateLimiter.leakybucket;

import com.java.learning.lld.rateLimiter.leakybucket.dto.Request;
import com.java.learning.lld.rateLimiter.leakybucket.service.impl.LeakyBucketRateLimiter;
import com.java.learning.lld.rateLimiter.leakybucket.service.RateLimiter;

import java.sql.Timestamp;
import java.util.Random;
import java.util.stream.Stream;

public class RateLimiterApplication {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new RequestThread("user1"));
//        Thread thread2 = new Thread(new RequestThread("user2"));
        thread1.start();
//        thread2.start();
    }

    public static class RequestThread implements Runnable{
        private String userId;
        RateLimiter rateLimiter = new LeakyBucketRateLimiter(4, 4);

        public RequestThread(String userId) {
            this.userId = userId;
        }

        @Override
        public void run() {
            Stream.iterate(0, i -> i + 1).limit(100).forEach(num -> {
                Request request = new Request(userId);
                boolean isAllowed = rateLimiter.isAllowed(request);
                System.out.println(Timestamp.from(request.getTimestamp()) + " : Request " + num + ", for user : "+request.getUserId() + " is allowed: " + isAllowed);
                try {
                    Thread.sleep(new Random().nextInt(200, 300));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
