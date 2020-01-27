package com.olegstotsky.chapter2;

public class Task3 {
    // O(N) time, O(1) memory
    public static void removeMiddle(Node middle) {
        while (middle.next != null) {
            Node next = middle.next;
            middle.num = next.num;
            middle.next = next.next;
            middle = next;
        }
    }

    //O(1) time, O(1) memory
    public static boolean removeMiddleCorrect(Node middle) {
        if (middle == null || middle.next == null) {
            return false;
        }
        Node next = middle.next;
        middle.num = next.num;
        middle.next = next.next;
        return true;
    }

    public static void main(String[] args) {
        Node l = Utils.genList(1);
        Node m = Utils.genList(3);
        Node r = Utils.genList(4, 5);
        l.next = m;
        m.next = r;
        removeMiddleCorrect(m);
        System.out.println(l.toString());
    }
}
