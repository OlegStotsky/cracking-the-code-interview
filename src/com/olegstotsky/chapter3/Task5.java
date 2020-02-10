package com.olegstotsky.chapter3;

import java.util.Stack;

public class Task5 {
    public static void main(String[] args) {
        QueueUsingTwoStacks<Integer> Q = new QueueUsingTwoStacks<>();
        for (int i = 0; i < 10; ++i) {
            Q.push(i);
        }
        for (int i = 0; i < 10; ++i) {
            System.out.println(Q.pop());
        }
    }

    static class QueueUsingTwoStacks<T> {
        private final Stack<T> s1 = new Stack<>();
        private final Stack<T> s2 = new Stack<>();

        public void push(T elem) {
            s1.push(elem);
        }

        public T pop() {
            if (!s1.empty()) {
                while (!s1.empty()) {
                    s2.push(s1.pop());
                }
            }

            return s2.pop();
        }
    }
}
