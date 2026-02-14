package com.java.learning.dsa.linkedlist;

public class ReOrderLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addToTail(new ListNode<>(i));
        }

        ListNode<Integer> reOrder = linkedList.reOrderList();

        while (reOrder!=null){
            System.out.print(reOrder.getVal() + " -> ");
            reOrder = reOrder.getNext();
        }
    }
}
