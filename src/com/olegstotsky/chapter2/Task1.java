package com.olegstotsky.chapter2;

import java.util.HashSet;

public class Task1 {
    //O(N) memory, O(N) time
    public static Node removeDuplicates(Node node) {
        Node head = node;
        HashSet<Integer> s = new HashSet<>();
        Node prev = null;
        while (node != null) {
            Node next = node.next;
            if (s.contains(node.num)) {
                prev.next = next;
            } else {
                prev = node;
                s.add(node.num);
            }
            node = next;
        }

        return head;
    }

    // O(1) memory, O(N^2) time
    public static Node removeDuplicatesConstMemory(Node node) {
        Node head = node;
        while (node != null) {
            Node runner = node.next;
            while (runner != null && runner.num == node.num) {
                runner = runner.next;
            }
            node.next = runner;
            node = runner;
        }

        return head;
    }

    public static Node genList(int... arr) {
        Node ans = null;
        Node head = null;
        for (int x : arr) {
            Node curNode = new Node(x);
            if (ans == null) {
                ans = curNode;
                head = curNode;
            } else {
                ans.next = curNode;
                ans = curNode;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(genList(1, 1, 2, 3, 3, 4, 4, 4, 1, 1, 1, 1, 1, 5)).toString());
    }
}
