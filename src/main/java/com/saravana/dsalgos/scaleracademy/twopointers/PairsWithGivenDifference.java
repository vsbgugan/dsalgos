package com.saravana.dsalgos.scaleracademy.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PairsWithGivenDifference {

    public int solve(List<Integer> A, int B) {
        int i = 0;
        int j = 1;
        int count = 0;
        int n = A.size();
        Collections.sort(A);
        while(j < n) {
            int diff = A.get(j) - A.get(i);
            if(diff < B) {
                j++;
            } else if(diff > B) {
                i++;
                if(i == j)  j++;
            } else {
                count++;
                i++;
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int ans = new PairsWithGivenDifference().solve(Arrays.asList(8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3), 3);
        System.out.println("ans = " + ans);
    }
}
