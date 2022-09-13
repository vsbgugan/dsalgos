package com.saravana.dsalgos.scaleracademy.mod;

public class CombinationModPrime {
    public int solve(int A, int B, int C) {
        long nFact = fact(A, C);
        long nrFact = fact(A - B, C);
        long rFact = fact(B, C);
        return (int)(((nFact % C) * pow((nrFact * rFact) % C, C - 2, C)) % C);
    }

    public long fact(long n, long mod) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res = ((res % mod) * (i % mod)) % mod;
        }
        return res;
    }

    public long pow(long A, long B, long C) {
        if (A == 0) return 0;
        if (B == 0) return 1;
        long res = pow(A, B / 2, C);
        res = ((res % C) * (res % C)) % C;
        // if B was odd multiple A one more time
        if (B % 2 == 1) res = (res * (A % C)) % C;
        if (res < 0) {
            res += C;
        }
        return res;
    }

    public static void main(String[] args) {
        int solve = new CombinationModPrime().solve(51299, 25646, 3685739);
        System.out.println("solve = " + solve);
    }
}
