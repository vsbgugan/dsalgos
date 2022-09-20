package com.saravana.dsalgos.scaleracademy.arrays;

import java.util.Arrays;
import java.util.List;

public class FindSecondLargestElement {

    public int solve(List<Integer> A) {
        if(A.size() < 2) return -1;
        int max = A.get(A.size()-1);
        int max2 = Integer.MIN_VALUE;
        for(int i : A) {
            if(i >= max) {
                max2 = max;
                max = i;
            } else if(i > max2) {
                max2 = i;
            }
        }
        return max2;
    }

    public int solve(int[] A) {
        int N = A.length;
        int firstlargest = A[0];
        int secondLargest = -1;
        if(N <= 1) return -1;
        for(int i=0; i<N; i++){
            if(A[i] >= firstlargest){
                secondLargest = firstlargest;
                firstlargest = A[i];
            }else if(A[i] > secondLargest){
                secondLargest = A[i];
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int solve = new FindSecondLargestElement().solve(Arrays.asList(2, 1));
//        int solve = new FindSecondLargestElement().solve(new int[]{ 2, 1 });
        System.out.println("solve = " + solve);
    }
}
