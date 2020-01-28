package com.olegstotsky.chapter2;

public class Task5Better {
    public static Node sumBackward(Node l, Node r, int carry) {
        if (l == null && r == null && carry == 0) {
            return null;
        }

        Node result = new Node(0);
        int value = carry;
        if (l != null) {
            value += l.num;
        }
        if (r != null) {
            value += r.num;
        }
        result.num = value % 10;
        if (l != null || r != null) {
            Node next = sumBackward(l == null ? null : l.next, r == null ? null : r.next, value >= 10 ? 1 : 0);
            result.next = next;
        }
        return result;
    }

    public static void main(String[] args) {
        Node l = Utils.genList(9, 9);
        Node r = Utils.genList(9, 9);
        System.out.println(sumBackward(l, r ,0).toString());
    }
}

