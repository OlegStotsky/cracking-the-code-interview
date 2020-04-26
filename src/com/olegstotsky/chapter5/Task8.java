package com.olegstotsky.chapter5;

public class Task8 {
    /*
        first_byte_num = y * (width / 8) + x_1 / 8
        last_byte_num = y * (width / 8) + x_2 / 8
        l_first_byte = x_1
        r_second_byte = 8 - x_2
        In the mid bytes - and with 0, add -128
        in the left byte - and with 11..0, add 00..11
        in the right byte - and with 00..11, add 11..00
     */
    private static void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y) {
        int firstByteNum = y * (width / 8) + x1 / 8;
        int secondByteNum = y * (width / 8) + x2 / 8;
        int firstByteOffset = x1 % 8;
        int secondByteOffset = x2 % 8;
        byte leftByteAndMask = getMask(0, firstByteOffset-1);
        byte rightByteAndMask = getMask(secondByteOffset, 8);
        byte leftByteOrMask = getMask(firstByteOffset-1, firstByteNum == secondByteNum ? secondByteOffset : 8);
        byte rightByteOrMask = getMask(firstByteNum == secondByteNum ? firstByteOffset : 0, secondByteOffset);
        screen[firstByteNum] &= leftByteAndMask;
        screen[firstByteNum] |= leftByteOrMask;
        if (firstByteNum != secondByteNum) {
            screen[secondByteNum] &= rightByteAndMask;
            screen[secondByteNum] |= rightByteOrMask;
        }
        for (int i = firstByteNum + 1; i < secondByteNum - 1; ++i) {
            screen[i] = (byte)-256;
        }
    }

    //0 1 2 3 4 5 6 7
    //7 6 5 4 3 2 1 0
    private static byte getMask(int l, int r) {
        byte ans = 0;
        for (int i = l; i < r; ++i) {
            ans |= 1 << 8-i-1;
        }
        return ans;
    }

    public static void main(String[] args) {
        byte[] screen = {0, 0, 0, 0, 0, 0};
        drawHorizontalLine(screen, 16, 0, 15, 0);
        System.out.println(screen[2]);
    }
}
