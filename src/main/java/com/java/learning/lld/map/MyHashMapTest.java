package com.java.learning.lld.map;

public class MyHashMapTest {
    public static void main(String[] args) {
        MyMap<String, Integer> myMap = new MyHashMap<>();
        myMap.put("A", 10);
        myMap.put("B", 20);
        System.out.println(myMap.get("A"));
        System.out.println(myMap.get("B"));
        myMap.remove("A");
        System.out.println(myMap.get("A"));
        myMap.put("B", 10);
        myMap.put("C", 30);
        System.out.println(myMap.get("A"));
        System.out.println(myMap.get("B"));
        System.out.println(myMap.get("C"));
    }
}
