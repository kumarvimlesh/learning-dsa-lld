package com.java.learning.lld.foodDeliverySystem.enums;

public interface RedisManager<K, V> {
    V put(K key, V value);
    V get(K k);
}
