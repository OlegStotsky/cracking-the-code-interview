package com.olegstotsky.chapter3;

import java.util.Stack;

public class Task4 {
    public static void main(String[] args) {
        Stack<Integer> first = new Stack<>();
        Stack<Integer> second = new Stack<>();
        Stack<Integer> third = new Stack<>();

        int n = 4;

        for (int i = n; i >= 1; i--) {
            first.add(i);
        }

        move(4, first, third, second);
        while (!third.empty()) {
            System.out.println(third.pop());
        }
    }

    public static void move(int n, Stack<Integer> src, Stack<Integer> dest, Stack<Integer> tmp) {
        if (n <= 0) {
            return;
        }

        move(n - 1, src, tmp, dest);
        dest.add(src.pop());
        move(n - 1, tmp, dest, src);
    }
}
