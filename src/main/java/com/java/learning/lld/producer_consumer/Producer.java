package com.java.learning.lld.producer_consumer;

import java.util.Map;

public class Producer extends Thread{
    private final SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Producing: " + i);
            sharedResource.produce(Map.of(String.valueOf(i), i) );
        }
    }
}
