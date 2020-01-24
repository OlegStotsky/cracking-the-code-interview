package com.olegstotsky.chapter1;

public class Task7 {
    public static void zerofy(int[][] m) {
        int rows = m.length;
        if (rows == 0) {
            return;
        }
        int cols = m[0].length;
        boolean[] shouldMarkRow = new boolean[rows];
        boolean[] shouldMarkColumn = new boolean[cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (m[i][j] == 0) {
                    shouldMarkRow[i] = true;
                    shouldMarkColumn[j] = true;
                }
            }
        }
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (shouldMarkColumn[j] || shouldMarkRow[i]) {
                    m[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int rows = 3;
        int cols = 4;
        int[][] m = new int[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                m[i][j] = i*cols + j;
            }
        }
        m[2][0] = 0;
        m[0][3] = 0;
        zerofy(m);
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                System.out.print(m[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}
