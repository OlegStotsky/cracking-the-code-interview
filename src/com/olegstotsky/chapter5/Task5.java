package com.olegstotsky.chapter5;

public class Task5 {
    private static int numBitsToConvert(int x, int y) {
        return bitCount(x ^ y);
    }

    private static int bitCount(int x) {
        int cnt = 0;
        for (; x != 0; x >>= 1) {
            cnt += x & 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(numBitsToConvert(31, 14));
    }
}
