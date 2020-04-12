package com.olegstotsky.chapter5;

public class Task6 {
    private static int swapBits(int x) {
        int oddBits = getOddBits(x);
        int evenBits = getEvenBits(x);
        return oddBits + evenBits;
    }

    private static int getOddBits(int x) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            x >>= 1;
            if (i % 2 == 1) {
                continue;
            }
            ans += bitAt(i);
        }
        return ans;
    }

    private static int getEvenBits(int x) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            if (i % 2 == 1) {
                x >>= 1;
                continue;
            }
            ans += bitAt(i + 1);
            x >>= 1;
        }
        return ans;
    }

    private static int bitAt(int pos) {
        int ans = 1;
        for (int i = 0; i < pos; ++i) {
            ans <<= 1;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
