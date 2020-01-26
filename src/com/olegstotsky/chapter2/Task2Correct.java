package com.olegstotsky.chapter2;

public class Task2Correct {
    //O(N) memory, O(N) time
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

    // O(1) memory, O(N) time
    public static Node kthToLastV2(Node head, int k) {
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < k; ++i) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node l = Utils.genList(5, 4, 200, 100);
        System.out.println(kthToLastV2(l, 2).toString());
    }
}
