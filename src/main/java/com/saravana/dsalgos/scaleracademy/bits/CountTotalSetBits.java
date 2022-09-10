package com.saravana.dsalgos.scaleracademy.bits;

public class CountTotalSetBits {

    public int solve(int A) {
        long MOD = 1000000007;
        if(A == 0) return 0;
        int nearestPowerOf2 = getNearestPowerOf2(A);
        long bitsUntilNearestPower = (long) nearestPowerOf2 * (1L << (nearestPowerOf2 - 1));
        long remainingBits = (A - (1L << nearestPowerOf2) + 1);
        long maxPowerAndMSBBitCount = ((bitsUntilNearestPower % MOD) + (remainingBits % MOD)) % MOD;
        long reducedBits = solve(A - (1 << nearestPowerOf2));
        return (int)(((maxPowerAndMSBBitCount % MOD) + (reducedBits % MOD)) % MOD);

    }

    public int getNearestPowerOf2(int A) {
        int cnt = 0;
        while(A >= 2) {
            cnt++;
            A = A / 2;
        }
        return cnt;
    }
    public static void main(String[] args) {
        int solve = new CountTotalSetBits().solve(1000000000);
        System.out.println("solve = "+ solve);
    }
}
