package com.olegstotsky.chapter2;

import java.util.ArrayDeque;
import java.util.ArrayList;

/* I actually misunderstood the task
   and thought that the task was to find k-th order statistic.
   So correct implementation is in Task2Correct
 */
public class Task2 {
    // O(NlogN) time, O(N) memory
    public static int kthOrderStatistic(Node head, int k) {
        head = mergeSort(head);
        while (k > 1) {
            head = head.next;
            k--;
        }

        return head.num;
    }

    public static Node mergeSort(Node head) {
        ArrayDeque<Node> Q = new ArrayDeque();
        Node curNode = head;
        while (curNode != null) {
            Node tmp = curNode.next;
            curNode.next = null;
            Q.add(curNode);
            curNode = tmp;
        }
        while (Q.size() > 1) {
            Node first = Q.removeFirst();
            Node second = Q.removeFirst();
            Node newHead = merge(first, second);
            Q.push(newHead);
        }

        return Q.removeFirst();
    }

    public static Node merge(Node l, Node r) {
        if (r == null) {
            return l;
        }
        if (l == null) {
            return r;
        }
        if (l.num < r.num) {
            Node mergeResult = merge(l.next, r);
            l.next = mergeResult;
            return l;
        } else {
            Node mergeResult = merge(l, r.next);
            r.next = mergeResult;
            return r;
        }
    }

    public static void main(String[] args) {
        Node test = Utils.genList(5, 6, 1, 2, 50, 3, 4);
        System.out.println(kthOrderStatistic(test, 2));
    }
}
