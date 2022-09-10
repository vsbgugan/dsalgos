package com.saravana.dsalgos.scaleracademy.mod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeSubsequences {
    public int solve(List<Integer> A) {
        int max = Integer.MIN_VALUE;
        for(int i: A) {
            max = Math.max(max, i);
        }
        int N = max;
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i=2;i<=N;i++) {
            if(isPrime[i]) {
                for(int j=2*i;j<=N;j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        int countPrime = 0;
        for(int i: A) {
            if(isPrime[i]) countPrime++;
        }
        return ((int)Math.pow(2, countPrime)) - 1;
    }

    public static void main(String[] args) {
        new PrimeSubsequences().solve(Arrays.asList(9, 4, 9, 1, 5));
    }
}
