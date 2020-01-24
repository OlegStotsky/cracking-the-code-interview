package com.olegstotsky.chapter1;

public class Task5 {
    static String compress(String s) {
        int i = 0;
        int j = 0;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        while (i < n && j < n) {
            if (chars[j] != chars[i]) {
                sb.append(chars[i]);
                sb.append(String.valueOf(j-i));
                i = j;
            } else {
                j++;
            }
        }

        sb.append(chars[i]);
        sb.append(j-i);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(compress("aa"));
    }
}
