package com.saravana.dsalgos.scaleracademy.arrays;

public class SubArraySumLessThanK {

    public int solve(int[] A, int B) {
        int n = A.length;
        int start = 0;
        int end = 0;
        int count=0;
        int sum = A[0];
        while(start < n && end < n) {
            if(sum < B) {
                end++;
                if(end > start) {
                    count += end - start;
                }
                if(end < n) {
                    sum += A[end];
                }
            } else {
                sum -= A[start];
                start++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] input = {6, 6, 6, 6};
        int count = new SubArraySumLessThanK().solve(input, 5);
        System.out.println("count = " + count);
    }
}
