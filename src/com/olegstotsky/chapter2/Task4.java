package com.olegstotsky.chapter2;

public class Task4 {
    //5 4 3 2 1
    //3 2 1 4 5
    public static Node partition(Node head, int val) {
        Node left = null;
        Node right = null;
        Node leftHead = null;

        while (head != null) {
            Node next = head.next;
            if (head.num < val) {
                if (left == null) {
                    left = head;
                    leftHead = head;
                } else {
                    left.next = head;
                    left = head;
                }
            } else {
                if (right == null) {
                    right = head;
                    right.next = null;
                } else {
                    head.next = right;
                    right = head;
                }
            }

            head = next;
        }

        if (leftHead == null) {
            return right;
        }

        left.next = right;
        return leftHead;
    }

    public static void main(String[] args) {
        Node n = Utils.genList(5, 4, 4, 1);
        System.out.println(partition(n, 3).toString());
    }
}
