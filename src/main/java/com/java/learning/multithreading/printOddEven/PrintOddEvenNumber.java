package com.java.learning.multithreading.printOddEven;

public class PrintOddEvenNumber {
    private int current = 1;
    private int max = 20;
    public static void main(String[] args) {
        PrintOddEvenNumber printOddEvenNumber = new PrintOddEvenNumber();
        Thread thread1 = new Thread(printOddEvenNumber.new PrintOdd());
        Thread thread2 = new Thread(printOddEvenNumber.new PrintEven());
        thread1.start();
        thread2.start();
    }

    public class PrintOdd implements Runnable{
        @Override
        public void run() {
            synchronized (PrintOddEvenNumber.this) {
                while (current <= max) {
                    while (current % 2 == 0) {
                        try {
                            PrintOddEvenNumber.this.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("Odd : " + current);
                    current++;
                    PrintOddEvenNumber.this.notifyAll();
                }
            }
        }
    }

    public class PrintEven implements Runnable{
        @Override
        public void run() {
            synchronized (PrintOddEvenNumber.this) {
                while (current <= max) {
                    while (current % 2 == 1) {
                        try {
                            PrintOddEvenNumber.this.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("Even : " + current);
                    current++;
                    PrintOddEvenNumber.this.notifyAll();
                }
            }
        }
    }
}
