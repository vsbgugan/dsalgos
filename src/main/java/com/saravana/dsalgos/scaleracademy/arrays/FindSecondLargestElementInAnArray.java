package com.saravana.dsalgos.scaleracademy.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSecondLargestElementInAnArray {

    public int solve(List<Integer> A) {
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        if(A.size() < 2) return -1;
        for(int i : A) {
            if(i > max) {
                max2 = i;
                max = i;
            }
            if(i < max && i > max2) max2 = i;
        }
        if(max2 == Integer.MIN_VALUE) return -1;
        else return max2;
    }


    public static void main(String[] args) {
        int solve = new FindSecondLargestElementInAnArray().solve(Arrays.asList(589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291, 589074291));
        System.out.println(solve);
    }
}
