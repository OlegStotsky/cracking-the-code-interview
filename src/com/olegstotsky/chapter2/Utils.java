package com.olegstotsky.chapter2;

public class Utils {
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
}
