package com.java.learning.multithreading;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenZeroPrinter {

    private int number = 1;
    private final int n = 10;
    private final ReentrantLock lock = new ReentrantLock();

    private final Condition zeroCondition = lock.newCondition();
    private final Condition oddCondition = lock.newCondition();
    private final Condition evenCondition = lock.newCondition();

    private boolean zeroTurn = false;

    public static void main(String[] args) {
        System.out.println("Hello World");
        OddEvenZeroPrinter printer = new OddEvenZeroPrinter();
        Thread evenThread = new Thread(() -> printer.printEven(), "Even Thread");
        Thread oddThread = new Thread(() -> printer.printOdd(), "Odd Thread");
        Thread zeroThread = new Thread(() -> printer.printZero(), "Zero Thread");
        evenThread.start();
        oddThread.start();
        zeroThread.start();
    }

    public void printZero(){
        for(int i = 0; i< n; i++){
            lock.lock();
            try{
                while(!zeroTurn){
                    zeroCondition.await();
                }
                System.out.println(Thread.currentThread().getName() + " 0");
                zeroTurn = false;
                if(number % 2 == 1){
                    oddCondition.signal();
                }
                else{
                    evenCondition.signal();
                }
            }
            catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            finally{
                lock.unlock();
            }
        }
    }

    public void printEven(){
        while(true){
            try{
                lock.lock();
                while(number%2 != 0 || zeroTurn){
                    if(number>n) return;
                    evenCondition.await();
                }
                if(number>n) return;
                System.out.println(Thread.currentThread().getName() + " " + number);
                number++;
                if(number>n) return;
                zeroTurn = true;
                zeroCondition.signal();
            }
            catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            finally{
                lock.unlock();
            }
        }
    }

    public void printOdd(){
        while(true){
            try{
                lock.lock();
                while(number%2 == 0 || zeroTurn){
                    if(number>n) return;
                    oddCondition.await();
                }
                if(number>n) return;
                System.out.println(Thread.currentThread().getName() + " " + number);
                number++;
                if(number>n) return;
                zeroTurn = true;
                zeroCondition.signal();
            }
            catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            finally{
                lock.unlock();
            }
        }
    }
}



