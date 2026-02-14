package com.java.learning.lld.rateLimiter.fixedwindow;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RateLimiterApplication {
    public static void main(String[] args) {
        Resource resource = new Resource(40);
        RateLimiter rateLimiter = new FixedWindowRateLimiter(10);

        ExecutorService executor = Executors.newFixedThreadPool(10);
        String[] users = {"user1", "user2"};
        Runnable readResource = () -> {
            String userId = users[new Random().nextInt(2)];
            if (rateLimiter.allowRequest(userId)){
                System.out.println("User : "+ userId +" reading data : ");
                resource.read();
            }
            else{
                System.out.println("User : "+ userId + " is not allowed");
            }
        };

        for (int i = 0; i < 100; i++){
            executor.submit(readResource);
        }
    }
}
