package com.olegstotsky.chapter2;

public class Node {
    public Node next = null;
    public int num;

    public Node(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        String s = "Node{" +
                "num=" + num +
                '}';
        if (next != null) {
            s += next.toString();
        }
        return s;
    }
}
