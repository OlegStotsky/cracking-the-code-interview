package com.olegstotsky.chapter5;

/*
   O(n*log(n)) time, O(n*log(n)) memory solution
 */
public class Task7 {
    private static int fetchBit(int x, int j) {
        return x & (1 << j);
    }

    private static int missingNum(int[] arr, int n) {
        int expectedSum = n * (n + 1) / 2;
        int realSum = 0;
        boolean isZeroMissing = true;
        for (int i = 0; i < arr.length; ++i) {
            int num = convertToNum(arr, i);
            if (num == 0) {
                isZeroMissing = false;
            }
            realSum += num;
        }

        if (isZeroMissing) {
            return 0;
        }
        return expectedSum - realSum;
    }

    private static int convertToNum(int[] arr, int pos) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            ans |= fetchBit(arr[pos], i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        System.out.println(missingNum(nums, 3));
    }
}
