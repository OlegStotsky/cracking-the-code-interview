package com.olegstotsky.chapter4;

public class Task6 {
    public static BinTreeNode minElement(BinTreeNode root) {
        if (root.left == null) {
            return root;
        }
        return root.left;
    }

    public static BinTreeNode suc(BinTreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return minElement(node.right);
        }

        if (node.parent == null) {
            return null;
        }
        while (node.parent.left != node) {
            node = node.parent;
        }

        return node.parent;
    }

    public static void main(String[] args) {
        BinTreeNode node = new BinTreeNode(4, new BinTreeNode(2), new BinTreeNode(5), null);
        System.out.println(suc(node).val);
        BinTreeNode q = new BinTreeNode(4);
        BinTreeNode q2 = new BinTreeNode(3, null, q, null);
        BinTreeNode q3 = new BinTreeNode(2, null, q2, null);
        BinTreeNode q4 = new BinTreeNode(8, q3, null, null);
        q.parent = q2;
        q2.parent = q3;
        q3.parent = q4;
        System.out.println(suc(q).val);
    }

    private static class BinTreeNode {
        int val;
        BinTreeNode left;
        BinTreeNode right;
        BinTreeNode parent;

        public BinTreeNode(int val, BinTreeNode left, BinTreeNode right, BinTreeNode parent) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public BinTreeNode(int val) {
            this.val = val;
        }
    }
}
