package com.olegstotsky.chapter3;

public class Node<T> {
    public T val;
    public Node<T> next;

    public Node(T val, Node<T> next) {
        this.val = val;
        this.next = next;
    }

    public Node(T val) {
        this.val = val;
    }
}
