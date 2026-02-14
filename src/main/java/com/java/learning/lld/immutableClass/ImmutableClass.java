package com.java.learning.lld.immutableClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutableClass {
    private final int a;
    private final int b;
    private final List<List<String>> list;

    public ImmutableClass(int a, int b, List<List<String>> list) {
        this.a = a;
        this.b = b;
        this.list = Collections.unmodifiableList(new ArrayList<>(list.stream().map(Collections::unmodifiableList).toList()));
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public List<List<String>> getList() {
        return new ArrayList<>(list.stream().map(ArrayList::new).toList());
    }

    public class Task implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread is running");
        }
    }

    public static void main(String[] args) {
        ImmutableClass immutableClass = new ImmutableClass(1, 2, List.of(List.of("a", "b"), List.of("c", "d")));
        Task task = immutableClass.new Task();
        Thread thread = new Thread(task);
        thread.start();
    }
}
