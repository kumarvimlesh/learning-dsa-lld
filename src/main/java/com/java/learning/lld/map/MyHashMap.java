package com.java.learning.lld.map;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.HashMap;

@EnableAsync
public class MyHashMap<K, V> implements MyMap<K, V>{
    int LIMIT = 16;
    int curSize = 0;
    Node[] buckets = new Node[LIMIT];

    @Override
    public V get(K key) {
        int hashValue = getHashValue(key);
        if (buckets[hashValue] != null){
            Node<K, V> node = buckets[hashValue];
            while (node!=null){
                if(node.key == key){
                    return node.value;
                }
                node = node.next;
            }
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        int hashValue = getHashValue(key);
        if (buckets[hashValue]==null){
            Node<K, V> node = new Node<>(key, value);
            buckets[hashValue] = node;
            curSize++;
        }
        else {
            Node<K, V> node = buckets[hashValue], prev = null;
            while (node!=null){
                if (node.key == key){
                    node.value = value;
                    return;
                }
                prev = node;
                node = node.next;
            }
            prev.next = new Node<>(key, value);
            curSize++;
        }
        if (curSize>=LIMIT){
            resizeBucket();
        }
    }

    @Async
    private void resizeBucket() {
        HashMap hashMap = new HashMap();
    }

    private int getHashValue(K key) {
        return key.hashCode()%LIMIT;
    }

    @Override
    public boolean remove(K key) {
        int hashValue = getHashValue(key);
        if (buckets[hashValue] != null){
            Node<K, V> node = buckets[hashValue], prev = null;
            if (node.key == key){
                buckets[hashValue] = null;
                return true;
            }
            while (node!=null){
                if(node.key == key){
                    prev.next = node.next;
                    return true;
                }
                prev = node;
                node = node.next;
            }
        }
        return false;
    }
}

