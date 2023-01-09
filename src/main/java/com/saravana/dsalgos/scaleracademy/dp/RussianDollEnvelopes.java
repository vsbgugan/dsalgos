package com.saravana.dsalgos.scaleracademy.dp;

import java.util.*;

public class RussianDollEnvelopes {

    public int solve(List<List<Integer>> A) {
        Collections.sort(A, new Comparator<>() {
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });

        int n = A.size();
        int[] lis = new int[n];
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            lis[i] = 0;
            for(int j=0;j<i;j++) {
                if(A.get(j).get(1) < A.get(i).get(1) && A.get(j).get(0) != A.get(i).get(0)) {
                    lis[i] = Math.max(lis[i], lis[j]);
                }
            }
            lis[i]++;
            ans = Math.max(ans, lis[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(6, 18),
                Arrays.asList(2, 14),
                Arrays.asList(5, 6),
                Arrays.asList(4, 15),
                Arrays.asList(8, 11),
                Arrays.asList(3, 11),
                Arrays.asList(11, 10),
                Arrays.asList(5, 11));
        int solve = new RussianDollEnvelopes().solve(lists);
        System.out.println("solve = " + solve);
    }
}
