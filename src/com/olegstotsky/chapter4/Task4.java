package com.olegstotsky.chapter4;

import java.util.ArrayList;

public class Task4 {
    static <T> ArrayList<ArrayList<BinTreeNode<T>>> createLists(BinTreeNode<T> root) {
        ArrayList<ArrayList<BinTreeNode<T>>> lists = new ArrayList<>();
        createListsImpl(root, 1, lists);
        return lists;
    }

    private static <T> void createListsImpl(BinTreeNode<T> root, int depth, ArrayList<ArrayList<BinTreeNode<T>>> lists) {
        if (root == null) {
            return;
        }

        if (depth > lists.size()) {
            lists.add(new ArrayList<>());
        }

        lists.get(depth - 1).add(root);
        createListsImpl(root.left, depth + 1, lists);
        createListsImpl(root.right, depth + 1, lists);
    }

    public static void main(String[] args) {
        BinTreeNode<Integer> node = new BinTreeNode(1, null, new BinTreeNode(4));
        System.out.println(createLists(node).toString());
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
}
