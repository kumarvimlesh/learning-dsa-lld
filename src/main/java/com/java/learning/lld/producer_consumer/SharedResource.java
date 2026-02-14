package com.java.learning.lld.producer_consumer;

import java.util.Map;
import java.util.Queue;

public class SharedResource {
    private final Queue<Map<String, Object>> queue;

    public SharedResource(Queue<Map<String, Object>> queue) {
        this.queue = queue;
    }

    public void produce(Map<String, Object> item) {
        synchronized (queue) {
            queue.add(item);
            queue.notifyAll(); // Notify consumers that an item is available
        }
    }

    public Map<String, Object> consume() throws InterruptedException {
        synchronized (queue) {
            while (queue.isEmpty()) {
                queue.wait();
                System.out.println("Waiting for items to be produced...");
            }
            return queue.poll();
        }
    }
}
