package com.saravana.dsalgos.scaleracademy.mod;

public class FindInverseModM {
    public int solve(int A, int B) {
        return ((int)(Math.pow(A % B, B-2))) % B;
    }
    public static void main(String[] args) {
        new FindInverseModM().solve(1, 1);

    }
}
