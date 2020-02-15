package com.olegstotsky.chapter4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 5);
        System.out.println(g.isThereAPath(1, 3));
    }

    private static class Graph {
        HashMap<Integer, List<Integer>> adjacencyLists = new HashMap<>();

        void addEdge(int u, int v) {
            List<Integer> adjListForU = adjacencyLists.get(u);
            if (adjListForU == null) {
                adjListForU = new ArrayList<Integer>();
            }
            adjListForU.add(v);
        }

        boolean isThereAPath(int u, int v) {
            HashSet<Integer> s1 = new HashSet<>();
            dfs(u, s1);
            return s1.contains(v);
        }

        void dfs(int u, HashSet<Integer> visited) {
            if (visited.contains(u)) {
                return;
            }

            visited.add(u);

            if (!adjacencyLists.containsKey(u)) {
                return;
            }

            for (Integer v : adjacencyLists.get(u)) {
                dfs(v, visited);
            }
        }

        public void print() {
            adjacencyLists.forEach((k, v) -> {
                System.out.println(k.toString() + " : " + v.toString());
            });
        }
    }
}
