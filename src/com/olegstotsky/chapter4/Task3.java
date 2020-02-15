package com.olegstotsky.chapter4;

// 1 2 3 4 5 6 7
// 1 2 3 4
//   4
// 2   6
//1 3  5 7
// 1 2 3 4
// 3
//1  4
// 2
//median = find_median(arr)
//left_tree = build_tree(l, median - 1)
//right_tree = build_tree(median+1, r)
//return new Node(median.val, left_tree, right_tree)
//n log2(n)
public class Task3 {
    // O(log n) time, O(N) memory
    public static BinTreeNode buildTreeFromArr(int[] arr) {
        return buildTreeFromArrImpl(0, arr.length, arr);
    }

    private static BinTreeNode buildTreeFromArrImpl(int l, int r, int[] arr) {
        if (r - l <= 0) {
            return null;
        }
        int medianIdx = l + findMedian(l, r);
        BinTreeNode leftNode = buildTreeFromArrImpl(l, medianIdx, arr);
        BinTreeNode rightNode = buildTreeFromArrImpl(medianIdx + 1, r, arr);
        return new BinTreeNode(arr[medianIdx], leftNode, rightNode);
    }

    private static int findMedian(int l, int r) {
        return (r - l) / 2;
    }

    public static void main(String[] args) {
//        buildTreeFromArr(new int[]{1}).print(0);
//        buildTreeFromArr(new int[]{1, 2}).print(0);
//        buildTreeFromArr(new int[]{1, 2, 3}).print(0);
//        buildTreeFromArr(new int[]{1, 2, 3, 4}).print(0);
        buildTreeFromArr(new int[]{1, 2, 3, 4, 5, 6, 7}).print(0);
    }

    private static class BinTreeNode {
        int val;
        BinTreeNode left;
        BinTreeNode right;

        public BinTreeNode(int val, BinTreeNode left, BinTreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        void print(int depth) {
            if (right != null) {
                right.print(depth + 1);
            }
            StringBuilder offset = new StringBuilder();
            for (int i = 0; i < depth; ++i) {
                offset.append(" ");
            }
            System.out.print(offset.toString());
            System.out.print(val);
            System.out.println();
            if (left != null) {
                left.print(depth + 1);
            }
        }
    }
}
