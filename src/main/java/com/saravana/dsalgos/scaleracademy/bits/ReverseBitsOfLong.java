package com.saravana.dsalgos.scaleracademy.bits;

public class ReverseBitsOfLong {

    public long reverse(long a) {
        long res = 0;
        for(int i = 0; i < Long.SIZE; i++) {
            res <<= 1;
            if((a & 1) > 0) res ^= 1;
            a >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        new ReverseBitsOfLong().reverse(3);
    }
}
