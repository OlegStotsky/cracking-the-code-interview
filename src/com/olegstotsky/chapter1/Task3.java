package com.olegstotsky.chapter1;

import java.util.HashMap;

public class Task3 {
    static boolean isAnagram(String s1, String s2) {
        HashMap<Character, Integer> counts1 = buildCounts(s1);
        HashMap<Character, Integer> counts2 = buildCounts(s2);

        boolean isFirstEqual = checkMapping(s1, counts1, counts2);
        boolean isSecondEqual = checkMapping(s2, counts2, counts1);
        return isFirstEqual && isSecondEqual;
    }

    static HashMap<Character, Integer> buildCounts(String s) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            int count = counts.getOrDefault(c, 0);
            counts.put(c, count+1);
        }

        return counts;
    }

    static boolean checkMapping(String s, HashMap<Character, Integer> m1, HashMap<Character, Integer> m2) {
        for (char c : s.toCharArray()) {
            int count = m1.getOrDefault(c, 0);
            Integer count2 = m2.get(c);
            if (count2 == null || count2.intValue() != count) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("a", "b"));
        System.out.println(isAnagram("ab", "baa"));
        System.out.println(isAnagram("aaac", "a"));
        System.out.println(isAnagram("cc", "ccb"));
        System.out.println(isAnagram("abcd", "bcad"));
    }
}
