package com.olegstotsky.chapter3;

import java.util.Stack;

public class Task6 {
    public static Stack<Integer> solve(Stack<Integer> S1) {
        Stack<Integer> S2 = new Stack<>();
        while (!S1.empty()) {
            int cur = S1.pop();
            int cnt = 0;
            while (!S2.empty() && cur < S2.peek()) {
                S1.push(S2.pop());
                cnt++;
            }
            S2.push(cur);
            for (int i = 0; i < cnt; ++i) {
                S2.push(S1.pop());
            }
        }

        return S2;
    }

    public static void printStack(Stack<Integer> S) {
        System.out.println("-----------------");
        while (!S.empty()) {
            System.out.println(S.pop());
        }
        System.out.println("-----------------");
    }

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(5);
        s1.push(4);
        s1.push(3);
        printStack(solve(s1));

        Stack<Integer> s2 = new Stack<>();
        s2.push(10);
        s2.push(1);
        s2.push(0);
        s2.push(5);
        printStack(solve(s2));
    }
}
