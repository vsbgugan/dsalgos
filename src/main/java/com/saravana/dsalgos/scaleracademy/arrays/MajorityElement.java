package com.saravana.dsalgos.scaleracademy.arrays;

import java.util.Arrays;
import java.util.List;

public class MajorityElement {

    public int majorityElement(final List<Integer> A) {
        int probableAns = A.get(0);
        int n = A.size();
        int cnt = 1;
        for(int i=1;i<n;i++) {
            if(A.get(i) == probableAns) {
                cnt++;
            } else if(cnt ==0) {
                probableAns = A.get(i);
                cnt++;
            } else {
                cnt--;
            }
        }
        return probableAns;
        // cnt = 0;
        // for(int i : A) {
        //     if(i == probableAns) cnt++;
        // }
        // return

    }

    public static void main(String[] args) {
        new MajorityElement().majorityElement(Arrays.asList());
    }
}
