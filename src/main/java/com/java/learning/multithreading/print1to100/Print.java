package com.java.learning.multithreading.print1to100;

import java.util.concurrent.Semaphore;

/*
   Print from 1 to 100 in sequence using 3 different threads
 */
public class Print {
    private int current = 1;
    private final int max = 100;
    private final Object lock = new Object();

    private Semaphore semaphore1 = new Semaphore(1);
    private Semaphore semaphore2 = new Semaphore(0);
    private Semaphore semaphore3 = new Semaphore(0);

    public void print1(){
        while (current <= max){
            try {
                semaphore1.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 1 : " + current);
            current++;
            semaphore2.release();
        }
    }

    public void print2(){
        while (current <= max){
            try {
                semaphore2.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 2 : " + current);
            current++;
            semaphore3.release();
        }
    }

    public void print3(){
        while (current <= max){
            try {
                semaphore3.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 3 : " + current);
            current++;
            semaphore1.release();
        }
    }

    public static void main(String[] args) {
        Print print = new Print();
        Thread thread1 = new Thread(print::print1);
        Thread thread2 = new Thread(print::print2);
        Thread thread3 = new Thread(print::print3);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
