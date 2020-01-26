package com.olegstotsky.chapter2;

public class Task2Correct {
    public static int kthToLast(Node head, int k) {
        if (head == null) {
            return 0;
        }
        int pos = kthToLast(head.next, k) + 1;
        if (pos == k) {
            System.out.println(head.num);
        }
        return pos;
    }

    public static void main(String[] args) {
        Node l = Utils.genList(5, 4, 200, 100);
        kthToLast(l, 2);
    }
}
