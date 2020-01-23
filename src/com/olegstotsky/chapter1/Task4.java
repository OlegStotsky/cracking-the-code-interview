package com.olegstotsky.chapter1;

import java.util.Arrays;

public class Task4 {
    static String encode(String s) {
        char[] chars = s.toCharArray();
        int numBackSpaces = numBackSpaces(chars);
        char[] result = new char[chars.length + 2*numBackSpaces];
        int j = 0;
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == ' ') {
                result[j] = '%';
                result[j+1] = '2';
                result[j+2] = '0';
                j += 3;
            } else {
                result[j] = chars[i];
                j++;
            }
        }

        return new String(result);
    }

    static int numBackSpaces(char[] chars) {
        int numBackSpaces = 0;
        for (char c : chars) {
            if (c == ' ') {
                numBackSpaces++;
            }
        }
        return numBackSpaces;
    }

    public static void main(String[] args) {
        System.out.println(encode("Mr  John Smith       "));
    }
}
