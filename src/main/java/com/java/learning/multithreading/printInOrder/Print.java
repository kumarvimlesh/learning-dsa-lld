package com.java.learning.multithreading.printInOrder;

import java.util.concurrent.CountDownLatch;

public class Print {
    private CountDownLatch countDownLatch1;
    private CountDownLatch countDownLatch2;

    public Print() {
        this.countDownLatch1 = new CountDownLatch(1);
        this.countDownLatch2 = new CountDownLatch(1);
    }

    public String method1() throws InterruptedException {
        Thread.sleep(5000);
        this.countDownLatch1.countDown();
        return "This is method 1";
    }

    public String method2() throws InterruptedException {
        countDownLatch1.await();
        Thread.sleep(3000);
        countDownLatch2.countDown();
        return "This is method 2";
    }

    public String method3() throws InterruptedException {
        countDownLatch2.await();
        Thread.sleep(1000);
        return "This is method 3";
    }
}
