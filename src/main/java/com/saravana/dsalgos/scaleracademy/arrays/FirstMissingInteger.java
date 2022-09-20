package com.saravana.dsalgos.scaleracademy.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstMissingInteger {

    public int firstMissingPositive(List<Integer> A) {
        int n = A.size();
        int i = 0;
        while(i < n) {
            if(A.get(i) >=1 && A.get(i) <= n) {
                if(A.get(i) != i+1 && A.get(i) != A.get(A.get(i)-1)) {
                    int destValue = A.get(i) ;
                    int destIndex = destValue - 1;
                    A.set(i, A.get(destIndex));
                    A.set(destIndex, destValue);
                } else i++;
            } else i++;
        }
        for(i=0;i<n;i++) {
            if(A.get(i) != i+1) return i+1;
        }
        return n+1;
    }


    public static void main(String[] args) {
        new FirstMissingInteger().firstMissingPositive(Arrays.asList(2, 3, 1, 2));
    }
}
