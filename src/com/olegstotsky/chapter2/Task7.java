package com.olegstotsky.chapter2;

import java.util.Stack;

public class Task7 {
    public static boolean isPalindrome(Node head) {
        int len = getLen(head);
        Stack<Integer> S = new Stack<>();
        for (int i = 0; i < Math.ceil((double)len / 2); ++i) {
            S.add(head.num);
            head = head.next;
        }
        if (len % 2 == 1) {
            S.pop();
        }
        while (head != null) {
            if (head.num != S.pop()) {
                return false;
            }
            head = head.next;
        }

        return true;
    }

    public static boolean isPalindromeV2(Node head) {
        Node slow = head;
        Node fast = head;
        Stack<Integer> S = new Stack<>();

        while (fast != null && fast.next != null) {
            S.add(slow.num);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.num != S.pop()) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }

    private static class Result {
        Node head;
        boolean isPalindrome;

        public Result(Node head, boolean isPalindrome) {
            this.head = head;
            this.isPalindrome = isPalindrome;
        }
    }

    public static boolean isPalindromeV3(Node head) {
        return isPalindromeV3Impl(head, getLen(head)).isPalindrome;
    }

    /*
        1 2 1
        1 2 2 1
        1
        []
        1 2
     */
    private static Result isPalindromeV3Impl(Node head, int len) {
        if (len == 0 || head == null) {
            return new Result(head, true);
        }
        if (len == 1) {
            return new Result(head.next, true);
        }

        Result result = isPalindromeV3Impl(head.next, len-2);
        boolean isPalindrome = head.num == result.head.num && result.isPalindrome;
        return new Result(result.head.next, isPalindrome);
    }

    private static int getLen(Node head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }

    public static void main(String[] args) {
        Node L = Utils.genList(1, 3, 1);
        System.out.println(isPalindromeV2(L));
        Node L2 = Utils.genList(1);
        System.out.println(isPalindromeV2(L2));
        Node L3 = Utils.genList(1, 2);
        System.out.println(isPalindromeV2(L3));
        Node L4 = Utils.genList(1, 2, 2, 1);
        System.out.println(isPalindromeV2(L4));
    }
}
