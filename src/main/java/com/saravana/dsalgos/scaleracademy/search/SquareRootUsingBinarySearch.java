package com.saravana.dsalgos.scaleracademy.search;

public class SquareRootUsingBinarySearch {

    public int sqrt(int A) {
        int l = 1;
        int r = A/2;
        if(A==0) return 0;
        int ans = 1;
        while(l <= r) {
            int mid = (l+r)/2;
            int sqr = mid * mid;
            if(sqr == A) return mid;
            else if(sqr > A) {
                r = mid -1;
            } else {
                ans = mid;
                l = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new SquareRootUsingBinarySearch().sqrt(930675566);
    }



}
