package com.olegstotsky.chapter4;

public class Task7 {
    public static BinTreeNode LCA(BinTreeNode left, BinTreeNode right) {
        if (left.depth < right.depth) {
            BinTreeNode tmp = left;
            left = right;
            right = tmp;
        }

        while (left.depth != right.depth) {
            left = left.parent;
        }

        while (left.parent != right.parent) {
            left = left.parent;
            right = right.parent;
        }

        return left.parent;
    }

    public static void main(String[] args) {
        BinTreeNode q1 = new BinTreeNode(2, 1);
        BinTreeNode q2 = new BinTreeNode(3, 2);
        BinTreeNode q3 = new BinTreeNode(4, 2);
        q2.parent = q1;
        q3.parent = q1;
        System.out.println(LCA(q2, q3).val);
    }

    private static class BinTreeNode {
        int val;
        BinTreeNode left;
        BinTreeNode right;
        BinTreeNode parent;
        int depth = 1;

        public BinTreeNode(int val, int depth, BinTreeNode left, BinTreeNode right, BinTreeNode parent) {
            this.val = val;
            this.depth = depth;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public BinTreeNode(int val, int depth) {
            this.val = val;
            this.depth = depth;
        }
    }
}
