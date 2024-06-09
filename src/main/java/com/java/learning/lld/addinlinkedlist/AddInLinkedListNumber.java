package com.java.learning.lld.addinlinkedlist;

public class AddInLinkedListNumber {
    public static void main(String[] args){
//        System.out.print("Hello");

        Node node = new Node(1);
        Node node1 = new Node(2);
        node.setNext(node1);
        node1.setNext(new Node(3));

        Node current = node;
        while (current != null) {
            System.out.print(current.getValue() + " -> ");
            current = current.getNext();
        }

        AddOneInNode addOneInNode = new AddOneInNode();
        Node ans = addOneInNode.addOne(node);

        System.out.println();
        current = ans;
        while (current != null) {
            System.out.print(current.getValue() + " -> ");
            current = current.getNext();
        }

    }
}

