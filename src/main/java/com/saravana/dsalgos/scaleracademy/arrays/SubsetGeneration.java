package com.saravana.dsalgos.scaleracademy.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetGeneration {
    public ArrayList<ArrayList<Integer>> subsets(List<Integer> A) {
        int n = A.size(); // n bits
        int total = (1 << n); // 2 ^ n
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<total;i++) {
            ArrayList<Integer> subset = new ArrayList<>();
            for(int j=n-1;j>=0;j--) {
                if((i & (1 << j)) != 0) {
                    subset.add(A.get(j));
                }
            }
            res.add(subset);
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> subsets = new SubsetGeneration().subsets(Arrays.asList(12, 13));
        System.out.println("subsets = " + subsets);
    }

}
