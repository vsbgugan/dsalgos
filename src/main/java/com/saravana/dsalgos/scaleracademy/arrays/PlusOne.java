package com.saravana.dsalgos.scaleracademy.arrays;

public class PlusOne {

    public int[] plusOne(int[] A) {
        int carry = 1;
        int n = A.length;
        for(int i = n-1;i>=0;i--) {
            int t1 = (A[i] + carry) / 10;
            int t2 = (A[i] + carry) % 10;
            A[i] = t2;
            carry = t1;
        }
        return A;
    }

    public static void main(String[] args) {
        new PlusOne().plusOne(new int[] { 0});
    }
}
