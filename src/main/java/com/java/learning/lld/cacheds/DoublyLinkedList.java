package com.java.learning.lld.cacheds;

class DoublyLinkedList<K, V> {
    private Node<K, V> head;
    private Node<K, V> tail;

    public DoublyLinkedList() {
        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        head.setNext(tail);
        tail.setPrev(head);
    }

    public void moveToHead(Node<K, V> node) {
        removeNode(node);
        addToHead(node);
    }

    public void addToHead(Node<K, V> node) {
        node.setNext(head.getNext());
        node.setPrev(head);
        head.getNext().setPrev(node);
        head.setNext(node);
    }

    public void removeNode(Node<K, V> node) {
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
    }

    public Node<K, V> removeTail() {
        if (tail.getPrev() == head)
            return null;
        Node<K, V> node = tail.getPrev();
        removeNode(node);
        return node;
    }
}
