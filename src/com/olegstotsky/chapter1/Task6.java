package com.olegstotsky.chapter1;

class Matrix {
    private int rows;
    private int cols;
    private int[][] m;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.m = new int[rows][cols];
    }

    public void set(int row, int col, int num) {
        this.m[row][col] = num;
    }

    public int get(int row, int col) {
        return this.m[row][col];
    }

    public int getNumColumns() {
        return this.cols;
    }

    public int getNumRows() {
        return this.rows;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                stringBuilder.append(this.get(i, j));
                stringBuilder.append(" ");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}

public class Task6 {
    public static Matrix transposed(Matrix m) {
        int rows = m.getNumRows();
        int cols = m.getNumColumns();

        if (rows == cols) {
            return transposeInPlace(m, rows, cols);
        }

        return transposeNormal(m, rows, cols);
    }

    private static Matrix transposeInPlace(Matrix m, int rows, int cols) {
        for (int i = 0; i < rows; ++i) {
            for (int j = i; j < cols; ++j) {
                int tmp = m.get(i, j);
                m.set(i, j, m.get(j, i));
                m.set(j, i, tmp);
            }
        }

        return m;
    }

    private static Matrix transposeNormal(Matrix m, int rows, int cols) {
        Matrix tmp = new Matrix(cols, rows);

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                tmp.set(j, i, m.get(i, j));
            }
        }

        return tmp;
    }


    public static void main(String[] args) {
        Matrix m = new Matrix(3, 3);
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                m.set(i, j, i*3+j);
            }
        }

        Matrix t = transposed(m);
        System.out.println(t.toString());
    }
}
