package com.java.learning.multithreading.printInOrder;

public class PrintInOrderApplication {

    public static void main(String[] args) throws InterruptedException {
        Print print = new Print();
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println(print.method1());;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                System.out.println(print.method2());;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                System.out.println(print.method3());;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
