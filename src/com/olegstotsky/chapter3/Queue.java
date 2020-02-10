package com.olegstotsky.chapter3;

public class Queue<T> {
    Node<T> head;
    Node<T> tail;

    void enqueue(T val) {
        if (head == null) {
            head = new Node<T>(val);
            tail = head;
            return;
        }
        Node<T> node = new Node<>(val);
        tail.next = node;
        tail = node;
    }

    T dequeue() {
        if (head == null) {
            return null;
        }
        Node<T> tmp = head;
        head = head.next;
        return tmp.val;
    }
}
