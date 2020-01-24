package com.olegstotsky.chapter1;

public class Task8 {
    public static boolean isSubstring(String s1, String s2) {
        return s2.contains(s1);
    }

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        return isSubstring(s2, s1+s1);
    }

    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(isRotation(s1, s2));
    }
}
