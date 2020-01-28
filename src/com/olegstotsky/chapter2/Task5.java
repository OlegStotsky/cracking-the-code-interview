package com.olegstotsky.chapter2;

import java.util.ArrayList;
import java.util.Stack;

public class Task5 {
    public static Node sum(Node l, Node r) {
        Stack stack = new Stack();
        if (l == null) {
            return r;
        }
        if (r == null) {
            return l;
        }
        Node resultHead = new Node(0);
        Node resultCur = resultHead;
        boolean carry = false;
        while (l != null || r != null) {
            Node curNode = new Node(0);
            if (carry) {
                curNode.num += 1;
                carry = false;
            }
            if (l == null) {
                curNode.num += l.num;
            }
            if (r == null) {
                curNode.num += r.num;
            }
            if (l != null && r != null) {
                curNode.num += l.num + r.num;
            }
            if (curNode.num >= 10) {
                curNode.num -= 10;
                carry = true;
            }
            resultCur.next = curNode;
            resultCur = curNode;
            if (l != null) {
                l = l.next;
            }
            if (r != null) {
                r = r.next;
            }
        }
        if (carry) {
            Node node = new Node(1);
            resultCur.next = node;
            resultCur = node;
        }

        return resultHead.next;
    }

    public static Node sumForward(Node l, Node r) {
        Node leftReversed = reverse(l);
        Node rightReversed = reverse(r);
        Node sum = sum(leftReversed, rightReversed);
        return reverse(sum);
    }

    public static Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node l = Utils.genList(9, 9);
        Node r = Utils.genList(9, 9);
        Node result = sumForward(l, r);
        System.out.println(result.toString());
    }
}
