package com.java.learning.lld.addinlinkedlist;

class AddOneInNode {
    public Node addOne(Node head) {
        head = reverseLinkedList(head);
        System.out.println();
        Node x = head;
        while (x != null) {
            System.out.print(x.getValue() + " -> ");
            x = x.getNext();
        }
        Node node = head;
        System.out.println("Node = " + node);
        int carry = 1;
        while (node != null && carry >= 1) {
            System.out.println("Coming");
            int sum = node.getValue() + carry;
            System.out.println(sum);
            node.setValue(sum % 10);
            carry = sum / 10;
            if (carry > 0 && node.getNext() == null) {
                node.setNext(new Node(0));
            }
            node = node.getNext();
        }
        return reverseLinkedList(head);
    }

    private Node reverseLinkedList(Node head) {
        Node prev = null;
        Node cur = head;
        while (cur != null) {
            Node tmp = cur.getNext();
            cur.setNext(prev);
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}
