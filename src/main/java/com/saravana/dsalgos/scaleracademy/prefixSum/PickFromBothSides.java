package com.saravana.dsalgos.scaleracademy.prefixSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PickFromBothSides {

    public int solve(List<Integer> A, int B) {
        ArrayList<Integer> prefixSum = new ArrayList<Integer>();
        int sum = 0;
        for(int i: A) {
            sum += i;
            prefixSum.add(sum);
        }
        // int headSum = prefixSum.get(B-1);
        // int tailSum = prefixSum.get(prefixSum.size()-1) - prefixSum.get(prefixSum.size()-B));

        int max = Integer.MIN_VALUE;
        for(int i=0;i<=B;i++) {

            // int leftMax = i
            // int rightMin = A.size() - B - i;
            int leftSum = i == 0 ? 0 : prefixSum.get(i-1);
            int rightSum = (i == B) ? 0 : prefixSum.get(A.size()-1) -  prefixSum.get(A.size()-1 - (B - i));
            int totalSum = leftSum + rightSum;
            if(totalSum > max) max = totalSum;

        }
        return max;
    }

    public static void main(String[] args) {
        int solve = new PickFromBothSides().solve(Arrays.asList(448, 200, 458, -382, -420, 796, -202, 281, 589, -202, -991, 157, -528, 622, -462, -708, -962, -821, -810, 657, 958, -809, 815), 4);
        System.out.println("solve = " + solve);
    }
}
