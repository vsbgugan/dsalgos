package com.saravana.dsalgos.scaleracademy.bits;

public class ReverseBits {

    public long reverse(long a) {
        long count = 0;
        System.out.printf("a = %s, count = %s \n", Long.toBinaryString(a), Long.toBinaryString(count));
        for(int i=0;i<64;i++) {
            long lsb = a & 1;
            long powerOf2 = (long)i << (31 -i);
            count = count + (powerOf2 * lsb);
            // long reversedLsb = lsb << (31 -i);
            // count = count | reversedLsb
            System.out.printf("a = %s, count = %s \n", Long.toBinaryString(a), Long.toBinaryString(count));
            a >>= 1;
        }
        System.out.printf("a = %s, count = %s \n", Long.toBinaryString(a), Long.toBinaryString(count));
        return count;
    }

    public static void main(String[] args) {
        new ReverseBits().reverse(3);
    }
}
