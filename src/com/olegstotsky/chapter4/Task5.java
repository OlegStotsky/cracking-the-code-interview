package com.olegstotsky.chapter4;

public class Task5 {
    public static boolean isBST(BinTreeNode<Integer> root) {
        Result result = isBSTImpl(root);
        return result.isBST;
    }

    private static Result isBSTImpl(BinTreeNode<Integer> root) {
        boolean leftProperty = true;
        int min = root.val;
        if (root.left != null) {
            Result leftResult = isBSTImpl(root.left);
            if (root.val < leftResult.max) {
                leftProperty = false;
            }
            min = Math.min(leftResult.min, min);
        }
        int max = root.val;
        boolean rightProperty = true;
        if (root.right != null) {
            Result rightResult = isBSTImpl(root.right);
            if (root.val > rightResult.min) {
                rightProperty = false;
            }
            max = Math.max(rightResult.max, max);
        }

        return new Result(leftProperty && rightProperty, min, max);
    }

    public static void main(String[] args) {
        BinTreeNode<Integer> node = new BinTreeNode<>(3, new BinTreeNode<>(2), new BinTreeNode<>(5));
        System.out.println(isBST(node));
        BinTreeNode<Integer> node2 = new BinTreeNode<>(3, new BinTreeNode<>(4), new BinTreeNode<>(5));
        System.out.println(isBST(node2));
    }

    private static class BinTreeNode<T> {
        T val;
        BinTreeNode<T> left;
        BinTreeNode<T> right;


        public BinTreeNode(T val, BinTreeNode<T> left, BinTreeNode<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public BinTreeNode(T val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "BinTreeNode{" +
                    "val=" + val;
        }
    }

    private static class Result {
        boolean isBST;
        int min;
        int max;

        public Result(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }
}
