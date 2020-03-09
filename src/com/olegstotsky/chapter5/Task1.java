package com.olegstotsky.chapter5;

public class Task1 {
    static int insert(int N, int M, int i, int j) {
        M = reverseNum(M);
        N = clear(N, j, i);
        for (int k = j; k <= i; ++k) {
            if ((M & 1) == 1) {
                N = insertOne(N, k);
            } else {
                N = insertZero(N, k);
            }
            M >>= 1;
        }

        return N;
    }

    private static int clear(int n, int j, int i) {
        for (int k = j; k <= i; ++k) {
            n = insertZero(n, k);
        }
        return n;
    }

    private static int reverseNum(int M) {
        int ans = 0;
        while (M != 0) {
            int digit = M % 10;
            ans = ans * 10 + digit;
            M /= 10;
        }
        return ans;
    }

    private static int insertZero(int N, int pos) {
        int mask = Integer.MIN_VALUE ^ (1 << (32 - pos));
        return N & mask;
    }

    private static int insertOne(int N, int pos) {
        int mask = 0 + (1 << (32 - pos));
        return N | mask;
    }

    public static void main(String[] args) {
        int N = 1 << 31;
        int M = 1;
        System.out.println(insert(N, M, 32, 32));
        System.out.println((1 << 31) + 1);
    }
}
