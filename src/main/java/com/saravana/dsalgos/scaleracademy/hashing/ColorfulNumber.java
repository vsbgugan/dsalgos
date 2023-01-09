package com.saravana.dsalgos.scaleracademy.hashing;

import java.util.HashSet;

public class ColorfulNumber {

    public int colorful(int A) {
        int n = Integer.toString(A).length();
        int[] digits = new int[n];
        int t = A;
        int k = 0;
        while(t > 0) {
            digits[n-1-k] = t % 10;
            t = t /10;
            k++;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++) {
            int product = 1;
            for(int j=i;j<n;j++) {
                product *= digits[j];
                if(set.contains(product)) {
                    return 0;
                }
            }
        }
        return 1;
    }


    public static void main(String[] args) {
        new ColorfulNumber().colorful(123);
    }
}
