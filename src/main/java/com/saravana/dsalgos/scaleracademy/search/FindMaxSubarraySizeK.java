package com.saravana.dsalgos.scaleracademy.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMaxSubarraySizeK {

    public int solve(List<Integer> A, int B) {
        int n = A.size();
        int l = 1;
        int r = n;
        int ans = 1;
        while(l <= r) {
            int mid = (1+r)/2;
            if(check(A, mid, B)) {
                ans = Math.max(ans, mid);
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return ans;
    }

    public boolean check(List<Integer> A, int K, int B) {
        int sum = 0;
        for(int i=0;i<K;i++) {
            sum += A.get(i);
        }
        if(sum > B) return false;
        for(int i=K;i<A.size();i++) {
            sum += A.get(i) - A.get(i-K);
            if(sum > B) return false;
        }
        return true;

    }

    public static void main(String[] args) {
        new FindMaxSubarraySizeK().solve(Arrays.asList(1, 2, 3, 4, 5), 10);
    }
}
