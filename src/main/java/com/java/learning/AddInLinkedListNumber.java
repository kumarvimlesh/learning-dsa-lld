package com.java.learning;

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

class Node{
    private int value;
    private Node next;
    Node(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public Node getNext(){
        return this.next;
    }

    public void setNext(Node node){
        this.next = node;
    }
}

class AddOneInNode{
    public Node addOne(Node head){
        head = reverseLinkedList(head);
        System.out.println();
        Node x = head;
        while (x != null) {
            System.out.print(x.getValue() + " -> ");
            x = x.getNext();
        }
        Node node = head;
        System.out.println("Node = "+node);
        int carry = 1;
        while (node!=null && carry>=1){
            System.out.println("Coming");
            int sum = node.getValue() + carry;
            System.out.println(sum);
            node.setValue(sum%10);
            carry = sum/10;
            if(carry>0 && node.getNext()==null){
                node.setNext(new Node(0));
            }
            node = node.getNext();
        }
        return reverseLinkedList(head);
    }

    private Node reverseLinkedList(Node head) {
        Node prev = null;
        Node cur = head;
        while (cur!=null){
            Node tmp = cur.getNext();
            cur.setNext(prev);
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}