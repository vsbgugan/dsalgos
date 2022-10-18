package com.saravana.dsalgos.scaleracademy.search;

public class AthMagicalNumber {

    int MOD = 1000000007;
    public int solve(int A, int B, int C) {
        int min = Math.min(B, C);
        long l = min;
        long r = min * (long)A;
        long ans = 0;
        while(l <= r) {
            long mid = (l+r)/2;
            long mutiples = countMultiples(mid, B, C);
            if(mutiples == A) {
                ans = mid;
                r = mid -1;
            } else if(mutiples < A) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return (int)(ans % MOD);
    }
    public long countMultiples(long mid, long B, long C) {

        long cnt = ((mid/B) % MOD + (mid/C) % MOD - (mid/lcm(B,C)) % MOD) % MOD;
        return cnt;
    }

    public long lcm(long B, long C) {
        return ((B % MOD * C  % MOD) % MOD) / gcd(B, C);
    }

    public long gcd(long B, long C) {
        while(B > 0) {
            long t = B;
            B = C % B;
            C = t;
        }
        return C;
    }


    public static void main(String[] args) {
        // 238134151
//        int solve = new AthMagicalNumber().solve(807414236, 3788, 38141);
        int solve = new AthMagicalNumber().solve(426344489, 36067, 29025);
        System.out.println("solve = " + solve);

    }
}
