package com.java.learning.multithreading.printInOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class PrintInOrderApplication {
    public static String method1() throws InterruptedException {
        Thread.sleep(5000);
        return "This is method 1";
    }

    public static String method2() throws InterruptedException {
        Thread.sleep(3000);
        return "This is method 2";
    }

    public static String method3() throws InterruptedException {
        Thread.sleep(1000);
        return "This is method 3";
    }

    public static void main(String[] args) throws InterruptedException {
        List<Callable<String>> tasks = new ArrayList<>();
        tasks.add(() -> method1());
        tasks.add(() -> method2());
        tasks.add(() -> method3());
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<String>> futures = executor.invokeAll(tasks);
        futures.forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        executor.shutdown();
    }
}
