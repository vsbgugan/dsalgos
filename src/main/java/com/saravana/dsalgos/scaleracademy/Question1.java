package com.saravana.dsalgos.scaleracademy;

public class Question1 {

    public int solve(int[] A) {
        int n = A.length;
        int min = Integer.MAX_VALUE;
        for(int i: A) {
            min = Math.min(min, i);
        }
        int first = -1;
        int second = -1;
        for(int i=0;i<n;i++) {
            if(A[i] == min) {
                if(first == -1) {
                    first = i;
                } else {
                    second = i;
                    break;
                }
            }
        }
        return  second - first + 1;
    }

    public static void main(String[] args) {
        int solve = new Question1().solve(new int[]{2, 1, 1, 2, 3, 4});
        System.out.println(solve);
    }
}
