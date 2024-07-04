package com.java.learning.lld.map;

public interface MyMap<K, V> {
    V get(K key);
    void put(K key, V value);
    boolean remove(K key);
}
