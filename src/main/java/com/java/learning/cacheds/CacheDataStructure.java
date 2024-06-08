package com.java.learning.cacheds;


import java.util.HashMap;
import java.util.Map;

class CacheDataStructure<K, V> {
    //Cache limit, if item added gets greater than limit first added record will be lost from cache
    private final static int LIMIT = 2;
    private final Map<K, Node<K, V>> map;
    private final DoublyLinkedList<K, V> doublyLinkedList;

    public CacheDataStructure() {
        this.map = new HashMap<>();
        this.doublyLinkedList = new DoublyLinkedList<>();
    }

    public void put(K key, V value){
        if (map.containsKey(key)){
            Node<K, V> node = map.get(key);
            node.setValue(value);
            doublyLinkedList.moveToHead(node);
        }
        else {
            if(map.size()>=LIMIT){
                Node<K, V> node = doublyLinkedList.removeTail();
                map.remove(node.getKey());
            }
            Node<K, V> node = new Node<>(key, value);
            map.put(key, node);
            doublyLinkedList.addToHead(node);
        }
    }

    public V get(K key){
        if (map.containsKey(key)){
            Node<K, V> node = map.get(key);
            doublyLinkedList.moveToHead(node);
            return node.getValue();
        }
        return null;
    }
}

