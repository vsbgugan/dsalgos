package com.saravana.dsalgos.scaleracademy.sorting;

import java.util.Arrays;
import java.util.List;

public class QuickSort {

    public List<Integer> solve(List<Integer> A) {
        int n = A.size();
        quickSort(A, 0, n-1);
        return A;
    }

    public void quickSort(List<Integer> A, int l, int r) {
        if(l >= r) return;
        int idx = rearrange(A, l, r);
        quickSort(A, l, idx-1);
        quickSort(A, idx+1, r);

    }

    public int rearrange(List<Integer> A, int l, int r) {
        int p1 = l+1;
        int p2 = r;
        int pivotIndex = l;
        int pivotElement = A.get(l);
        while(p1 <= p2) {
            if(A.get(p1) <= pivotElement) {
                p1++;
            } else if(A.get(p2) > pivotElement) {
                p2--;
            } else {
                int t = A.get(p1);
                A.set(p1, A.get(p2));
                A.set(p2, t);
                p1++;
                p2--;
            }
        }
        int t = A.get(pivotIndex);
        A.set(pivotIndex, A.get(p2));
        A.set(p2, t);
        return p2;

    }


    public static void main(String[] args) {
        new QuickSort().solve(Arrays.asList(3, 7, 1));

    }
}
