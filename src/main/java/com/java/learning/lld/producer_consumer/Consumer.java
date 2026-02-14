package com.java.learning.lld.producer_consumer;

public class Consumer extends Thread{
    private final SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        while (true)
            try {
                System.out.println("Consuming: ");
                System.out.println(sharedResource.consume());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}
