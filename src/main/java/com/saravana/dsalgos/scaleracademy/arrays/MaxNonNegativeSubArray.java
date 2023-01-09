package com.saravana.dsalgos.scaleracademy.arrays;

public class MaxNonNegativeSubArray {

    public int[] maxset(int[] A) {
        int n = A.length;
        int start = -1;
        int end = -1;
        int sum = 0;
        int i = 0;
        int max = Integer.MIN_VALUE;
        int maxLen = Integer.MIN_VALUE;
        while(i < n) {
            if(A[i] >= 0) {
                int t = i;
                while(i < n && A[i] >= 0) {
                    sum += A[i];
                    i++;
                }
                int len = i-t;
                if(sum > max) {
                    max = sum;
                    maxLen = Math.max(len, maxLen);
                    start = t;
                    end = i-1;
                } else if(sum == max && len > maxLen) {
                    max = sum;
                    maxLen = len;
                    start = t;
                    end = i-1;
                }
            }
            i++;
        }
        if(start != -1 && end != -1) {
            int[] res = new int[end - start + 1];
            for(int k=start;k<=end;k++) {
                res[k-start] = A[k];
            }
            return res;
        } else return new int[] {};

    }


    public static void main(String[] args) {
//        new MaxNonNegativeSubArray().maxset(new int[] { 1, 2, 5, -7, 2, 5});

        new MaxNonNegativeSubArray().maxset(new int[] { 1, 2, 5, -7, 2, 5});
//        new MaxNonNegativeSubArray().maxset(new int[] {756898537, -1973594324, -2038664370, -184803526, 1424268980});

    }
}
