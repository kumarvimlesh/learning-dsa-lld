package com.java.learning.dsa.linkedlist;

import lombok.Data;

@Data
public class ListNode<T> {
    private T val;
    private ListNode<T> next;

    public ListNode(T val) {
        this.val = val;
    }

    public ListNode(T val, ListNode<T> next) {
        this.val = val;
        this.next = next;
    }
}
