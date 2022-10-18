package com.saravana.dsalgos.scaleracademy.twopointers;

import java.util.Arrays;
import java.util.List;

public class PairsWithGivenSum {

    public int solve(List<Integer> A, int B) {
        int n = A.size();
        int i = 0;
        int j = n -1;
        long count = 0;
        while(i < j) {
            int a = A.get(i);
            int b = A.get(j);
            int sum = a + b;
            if(sum < B) {
                i++;
            } else if(sum > B) {
                j--;
            } else {
                // count++;
                // i++;
                // j--;
                while(i < n && i < j && A.get(i) == a) {
                    i++;
                    count++;
                }
                j--;
                while(j >= 0 && i < j && A.get(j) == b) {
                    j--;
                    count++;
                }
            }
        }
        return (int)(count % 1000000007);
    }


    public static void main(String[] args) {
//        new PairsWithGivenSum().solve(Arrays.asList( 1, 2, 6, 6, 7, 9, 9 ), 13);
        int ams = new PairsWithGivenSum().solve(Arrays.asList(2, 3, 3, 5, 7, 7, 8, 9, 9, 10, 10), 11);
        System.out.println("ams = " + ams);
    }
}
