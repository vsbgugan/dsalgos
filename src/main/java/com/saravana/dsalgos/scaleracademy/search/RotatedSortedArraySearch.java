package com.saravana.dsalgos.scaleracademy.search;

import java.util.Arrays;
import java.util.List;

public class RotatedSortedArraySearch {

    public int search(final List<Integer> A, int B) {
        int n = A.size();
        int l = 0;
        int r = n - 1;
        while(l <=r ) {
            int mid = (l+r)/2;
            if(A.get(mid) == B) return mid;
            if(A.get(l) <= A.get(mid)) {
                if(B >= A.get(l) &&  B <= A.get(mid)) {
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            } else {
                if(B >= A.get(mid+1) && B <= A.get(r)) {
                    l = mid+1;
                } else {
                    r = mid-1;
                }
            }
        }
        return -1;

    }
//    public int search(final List<Integer> A, int B) {
//        int n = A.size();
//        int l = 0;
//        int r = n-1;
//        int pivot = -1;
//        while(l <= r) {
//            int mid = (l+r)/2;
//            if(A.get(mid) == B) return mid;
//            if(A.get(mid-1) > A.get(mid)) {
//                pivot = mid;
//                break;
//            }
//            if(A.get(mid) > A.get(mid+1)) {
//                pivot = mid;
//                break;
//            }
//            if(A.get(l) > A.get(mid)) {
//                r = mid-1;
//                continue;
//            }
//            if(A.get(r) < A.get(mid)) {
//                l = mid+1;
//                continue;
//            }
//        }
//        if(A.get(pivot) == B) return pivot;
//        if(A.get(0) >= A.get(pivot)) {
//            l = 0;
//            r = pivot-1;
//        } else {
//            l = pivot + 1;
//            r = n-1;
//        }
//        while(l <= r) {
//            int mid = (l+r)/2;
//            if(A.get(mid) == B) return mid;
//            else if(A.get(mid) < B) l = mid + 1;
//            else r = mid - 1;
//        }
//        return -1;
//
//    }


    public static void main(String[] args) {
        int index = new RotatedSortedArraySearch().search(List.of(101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100), 202);
        System.out.println("index = " + index);
    }

}
