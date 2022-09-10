package com.saravana.dsalgos.scaleracademy.mod;

import java.util.Arrays;

public class LuckyNumbers {

    public int solve(int A) {
        int[] cnt = new int[A+1];
        boolean[] isPrime = new boolean[A+1];
        Arrays.fill(isPrime, true);
        cnt[1] = 1;
        for(int i=2;i<=A;i++) {
            // if(isPrime[i]) {
            for(int j=2*i;j<=A;j+=i) {
                isPrime[j] = false;
                if(isPrime[i]) {
                    cnt[j]++;
                }
            }
            // }
        }
        int cntLucky = 0;
        for(int i=3;i<=A;i++) {
            if(cnt[i] == 2) cntLucky++;
        }
        return cntLucky;
    }


    public static void main(String[] args) {
        new LuckyNumbers().solve(8);
    }
}
