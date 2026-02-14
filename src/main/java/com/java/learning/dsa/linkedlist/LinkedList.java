package com.java.learning.dsa.linkedlist;


import lombok.Data;

@Data
public class LinkedList<T> {
    private ListNode<T> head;
    private ListNode<T> tail;

    public LinkedList() {
    }

    public LinkedList(ListNode<T> head) {
        this.head = head;
    }

    public void addToHead(ListNode<T> node){
        if (this.tail==null)
            this.tail = node;
        node.setNext(head);
        this.head = node;
    }

    public void addToTail(ListNode<T> node){
        if (this.head==null)
            this.head = node;
        if (this.tail!=null)
            tail.setNext(node);
        this.tail = node;
    }

    public ListNode<T> reverseLinkedList() {
        ListNode<T> cur = this.head;
        ListNode<T> prev = null;
        while (cur!=null){
            ListNode<T> next = cur.getNext();
            cur.setNext(prev);
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode<T> createCopy(){
        if (this.head == null) return null;

        ListNode<T> dummy = new ListNode<>(null);
        ListNode<T> tail = dummy;
        ListNode<T> curr = this.head;

        while (curr != null) {
            tail.setNext(new ListNode<>(curr.getVal()));
            tail = tail.getNext();
            curr = curr.getNext();
        }
        return dummy.getNext();
    }

    public ListNode<T> reOrderList() {
        ListNode<T> copHead = this.head;
        ListNode<T> reversed = this.reverseLinkedList();

        if (this.head == null) return null;

        ListNode<T> dummy = new ListNode<>(null);
        ListNode<T> tail = dummy;
        ListNode<T> curr = this.head;

        while (curr != null) {
            tail.setNext(new ListNode<>(curr.getVal()));
            tail = tail.getNext();
            curr = curr.getNext();
        }
        return dummy.getNext();
    }
}
