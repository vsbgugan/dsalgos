package com.saravana.dsalgos.scaleracademy.arrays;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

public class SubArraySizeK {

    public int solve(List<Integer> A, int B) {
        int n = A.size();
        int sum = 0;
        int minIndex = 0;
        for(int i=0;i<B;i++) {
            sum += A.get(i);
        }
        for(int i=B;i<A.size();i++) {
            int prevSum = sum;
            sum += A.get(i);
            sum -= A.get(i-B);
            if(sum < prevSum) {
                minIndex = i-B+1;
            }


        }
        return minIndex;


    }

    public static void main(String[] args) {
        new SubArraySizeK().solve(List.of(15, 3, 15, 6, 9, 14, 8, 10, 9, 17), 1);
    }
}
