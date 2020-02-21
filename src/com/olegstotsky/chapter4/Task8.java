package com.olegstotsky.chapter4;

import java.util.ArrayList;
import java.util.Objects;

public class Task8 {
    public static boolean isSubtree(BinTreeNode T1, BinTreeNode T2) {
        ArrayList<BinTreeNode> t1InorderTraversal = traverse(T1);
        ArrayList<BinTreeNode> t2InorderTraversal = traverse(T2);

        int t1Iter = 0;
        int t2Iter = 0;

        while (t1Iter < t1InorderTraversal.size()) {
            t2Iter = 0;
            while (t2Iter < t2InorderTraversal.size()
                    && t1InorderTraversal
                    .get(t1Iter + t2Iter)
                    .equals(t2InorderTraversal.get(t2Iter))) {
                t2Iter++;
            }
            if (t2Iter == t2InorderTraversal.size()) {
                return true;
            }
            t1Iter++;
        }

        return false;
    }

    private static ArrayList<BinTreeNode> traverse(BinTreeNode t1) {
        ArrayList<BinTreeNode> traverseResult = new ArrayList<>();
        traverseImpl(t1, traverseResult);
        return traverseResult;
    }

    private static void traverseImpl(BinTreeNode t1, ArrayList<BinTreeNode> traverseResult) {
        if (t1.left != null) {
            traverseImpl(t1.left, traverseResult);
        }
        traverseResult.add(t1);
        if (t1.right != null) {
            traverseImpl(t1.left, traverseResult);
        }
    }

    public static void main(String[] args) {
        BinTreeNode n1 = new BinTreeNode(10);
        BinTreeNode n2 = new BinTreeNode(9);
        BinTreeNode n3 = new BinTreeNode(8);
        BinTreeNode n4 = new BinTreeNode(9);
//        BinTreeNode n5 = new BinTreeNode(7);
        n1.left = n2;
        n2.left = n3;
        n2.right = n4;
//        n3.left = n5;
        BinTreeNode d1 = new BinTreeNode(9);
        BinTreeNode d2 = new BinTreeNode(8);
        BinTreeNode d3 = new BinTreeNode(9);
        d1.left = d2;
        d1.right = d3;
        System.out.println(isSubtree(n1, d1));
    }

    private static class BinTreeNode {
        int val;
        BinTreeNode left;
        BinTreeNode right;

        public BinTreeNode(int val, BinTreeNode left, BinTreeNode right, BinTreeNode parent) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public BinTreeNode(int val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BinTreeNode other = (BinTreeNode) o;
            boolean valEquals = val == other.val;
            boolean leftEquals = (left == null && other.left == null) || (left != null && other.left != null && left.val == other.left.val);
            boolean rightEquals = (right == null && other.right == null) || (right != null && other.right != null && right.val == other.right.val);
            return valEquals && leftEquals && rightEquals;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }
}