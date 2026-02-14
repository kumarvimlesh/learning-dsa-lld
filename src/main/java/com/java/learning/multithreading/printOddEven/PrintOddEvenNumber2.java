package com.java.learning.multithreading.printOddEven;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintOddEvenNumber2 {
    private final int max;
    private int current = 1;

    private final Lock lock = new ReentrantLock();
    private final Condition oddTurn = lock.newCondition();
    private final Condition evenTurn = lock.newCondition();

    PrintOddEvenNumber2(int max){
        this.max = max;
    }

    public void printOdd(){
        lock.lock();
        while (current<=max){
            if (current%2==0){
                try {
                    oddTurn.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Odd : " + current);
            current++;
            evenTurn.signal();
        }
        lock.unlock();
    }

    public void printEven() {
        lock.lock();
        while (current<=max){
            while (current%2==1){
                try {
                    evenTurn.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Even : " + current);
            current++;
            oddTurn.signal();
        }
        lock.unlock();
    }

    public static void main(String[] args) {
        PrintOddEvenNumber2 printOddEvenNumber2 = new PrintOddEvenNumber2(20);
        Thread thread1 = new Thread(printOddEvenNumber2::printOdd);
        Thread thread2 = new Thread(printOddEvenNumber2::printEven);
        thread1.start();
        thread2.start();
    }
}
