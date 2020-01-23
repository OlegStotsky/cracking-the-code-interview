package com.olegstotsky.chapter1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Task1 {
    static boolean allCharsUnique(String s) {
        Set<Character> chars = new HashSet<Character>();
        for (char c : s.toCharArray()) {
            if (chars.contains(c)) {
                return false;
            }
            chars.add(c);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(allCharsUnique("aaa"));
        System.out.println(allCharsUnique(""));
        System.out.println(allCharsUnique("abcd"));
        System.out.println(allCharsUnique("abbcdd"));
    }
}
