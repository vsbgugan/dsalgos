package com.saravana.dsalgos.scaleracademy.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LargestZeroSumSubarray {
    public ArrayList<Integer> lszero(List<Integer> A) {
        int pfSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = -1, r = -1;
        int n = A.size();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n; i++) {
            int elem = A.get(i);
            pfSum = elem + pfSum;
            if(pfSum == 0) {
                l = 0;
                r = i;
                max = i + 1;
            } else if(map.containsKey(pfSum)) {
                int len = i - map.get(pfSum);
                if(len > max) {
                    max = len;
                    l = map.get(pfSum) + 1;
                    r = i;
                }
            } else {
                map.put(pfSum, i);
            }
        }
        ArrayList<Integer> results = new ArrayList<>();
        if(l == -1 || r == -1) return results;
        for(int i=l;i<=r; i++) {
            results.add(A.get(i));
        }
        return results;
    }

    public static void main(String[] args) {
        ArrayList<Integer> lszero = new LargestZeroSumSubarray().lszero(List.of(   -19, 8, 2, -8, 19, 5, -2, -23));
        System.out.println("lszero = " + lszero);
    }
}
