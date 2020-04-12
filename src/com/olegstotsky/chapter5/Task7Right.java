package com.olegstotsky.chapter5;

/* O(n) time, O(n*log(n)) memory solution
 */

import java.util.ArrayList;

class BitInteger {
    final static int NUM_BITS = 32;
    private int num;

    BitInteger(int num) {
        this.num = num;
    }

    int getBit(int pos) {
        return num & (1 << pos);
    }
}

public class Task7Right {
    private static int findMissing(ArrayList<BitInteger> nums) {
        return findMissingImpl(nums, 0, 0);
    }

    private static int findMissingImpl(ArrayList<BitInteger> nums, int column, int result) {
        if (column >= BitInteger.NUM_BITS || nums.size() == 0) {
            return result;
        }

        ArrayList<BitInteger> evenNums = new ArrayList<>();
        ArrayList<BitInteger> oddNums = new ArrayList<>();
        for (BitInteger x : nums) {
            if (x.getBit(column) == 0) {
                evenNums.add(x);
            } else {
                oddNums.add(x);
            }
        }

        int n = nums.size();
        if (n % 2 == 0) {
            if (oddNums.size() >= evenNums.size()) {
                return findMissingImpl(evenNums, column + 1, result | (0 << column));
            } else {
                return findMissingImpl(oddNums, column + 1, result | (1 << column));
            }
        } else {
            if (evenNums.size() >= oddNums.size()) {
                return findMissingImpl(oddNums, column + 1, result | (1 << column));
            } else {
                return findMissingImpl(evenNums, column + 1, result | (0 << column));
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<BitInteger> t1 = new ArrayList<>();
        t1.add(new BitInteger(1));
        System.out.println(findMissing(t1));
        ArrayList<BitInteger> t2 = new ArrayList<>();
        t2.add(new BitInteger(0));
        System.out.println(findMissing(t2));

        ArrayList<BitInteger> t3 = new ArrayList<>();
        t3.add(new BitInteger(0));
        t3.add(new BitInteger(1));
        t3.add(new BitInteger(3));
        System.out.println(findMissing(t3));

        ArrayList<BitInteger> t4 = new ArrayList<>();
        for (int i = 0; i <= 10; ++i) {
            if (i == 5) {
                continue;
            }
            t4.add(new BitInteger(i));
        }
        System.out.println(findMissing(t4));
    }
}
