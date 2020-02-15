package com.olegstotsky.chapter4;

public class Task1 {
    public static boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }

        int leftHeight = root.left == null ? 0 : root.left.height;
        int rightHeight = root.right == null ? 0 : root.right.height;

        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1, null, null, 1);
        Node n2 = new Node(2, null, null, 1);
        Node n3 = new Node(3, n1, n2, 2);
        Node n4 = new Node(4, n3, null, 3);
        System.out.println(isBalanced(n3));
    }

    private static class Node {
        int val;
        Node left;
        Node right;
        int height;

        public Node(int val, Node left, Node right, int height) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.height = height;
        }
    }
}
