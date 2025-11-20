package com.java.learning.lld.producer_consumer;

public class ProducerConsumerApplication {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(new java.util.LinkedList<>());

        Producer producer = new Producer(sharedResource);
        Consumer consumer = new Consumer(sharedResource);

        producer.start();
        consumer.start();
    }
}
