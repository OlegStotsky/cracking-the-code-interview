package com.olegstotsky.chapter3;

public class Task2 {
    public static void main(String[] args) {
        MinStack<Integer> minStack = new MinStack<>();
        minStack.push(5, 4, 3, 10, 1, 5, 5);
        while (!minStack.empty()) {
            System.out.println(minStack.min());
            minStack.pop();
        }
    }

    static class Pair<U, V> {
        public final U first;
        public final V second;

        Pair(U u, V v) {
            this.first = u;
            this.second = v;
        }
    }

    static class MinStack<T extends Comparable<T>> {
        private java.util.Stack<Pair<T, T>> stack = new java.util.Stack<>();

        void push(T... elems) {
            for (T elem : elems) {
                push(elem);
            }
        }

        void push(T x) {
            if (stack.empty() || x.compareTo(stack.peek().second) < 0) {
                stack.push(new Pair<>(x, x));
                return;
            }

            stack.push(new Pair<>(x, stack.peek().second));
        }

        T min() {
            return stack.peek().second;
        }

        T pop() {
            return stack.pop().first;
        }

        boolean empty() {
            return stack.empty();
        }
    }
}
