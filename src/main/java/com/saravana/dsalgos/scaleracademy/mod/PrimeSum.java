package com.saravana.dsalgos.scaleracademy.mod;

import java.util.*;

public class PrimeSum {

    public ArrayList<Integer> primesum(int A) {
        List<int[]> sumPairs = getPossibleSum(A);
        int[] smallesPair = Collections.min(sumPairs, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        ArrayList<Integer> result = new ArrayList<>();
        result.add(smallesPair[0]);
        result.add(smallesPair[1]);
        return result;

    }

    private List<int[]> getPossibleSum(int A) {
        boolean[] isPrime = findPrimeUpto(A);
        List<int[]> sumPairs = new ArrayList<>();
        for(int i=2;i<=A;i++) {
            if(isPrime[i] && isPrime[A-i]) {
                sumPairs.add(new int[] {i, A-i});
            }
        }
        return sumPairs;
    }

    private boolean[] findPrimeUpto(int N) {
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for(int i=2;i<=N;i++) {
            if(isPrime[i]) {
                for(int j=2*i;j<=N;j+=2) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }


    public static void main(String[] args) {
        new PrimeSum().primesum(184);

    }
}
