package com.olegstotsky.chapter2;

import java.util.HashSet;

public class Task6 {
    // 1 -> 2 -> 3 -> 4 -> 2
    public static Node getStartOfLoop(Node head) {
        HashSet<Node> S = new HashSet<>();
        while (head != null) {
            if (S.contains(head)) {
                return head;
            } else {
                S.add(head);
                head = head.next;
            }
        }

        return null;
    }

    public static Node getStartOfLoopIdiomatic(Node head) {
        Node slow = head;
        Node fast = head;

        while (slow.next != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        System.out.println(getStartOfLoop(n1).num);
    }
}
