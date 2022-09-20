package com.saravana.dsalgos.scaleracademy.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubMatrixSumQueries {


    public ArrayList<Integer> solve(List<List<Integer>> A, List<Integer> B, List<Integer> C, List<Integer> D, List<Integer> E) {
        int n = A.size();
        int m = A.get(0).size();
        int[][] pfSum = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                pfSum[i][j] = (j-1 < 0 ? 0 : pfSum[i][j-1]) + A.get(i).get(j); // prev col
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                pfSum[i][j] += (i-1 < 0 ? 0 : pfSum[i-1][j]); // prev row
            }
        }

        int q = B.size();
        ArrayList<Integer> res = new ArrayList<>(q);
        for(int i=0;i<q;i++) {
            int r1 = B.get(i) - 1;
            int c1 = C.get(i) - 1;
            int r2 = D.get(i) - 1;
            int c2 = E.get(i) - 1;
            int sum = pfSum[r2][c2];
            if(c1-1 >= 0) sum -= pfSum[r2][c1-1];
            if(r1-1 >= 0) sum -= pfSum[r1-1][c2];
            if(r1-1 >= 0 && c1 -1 >=0) sum += pfSum[r1-1][c1-1];
            res.add(sum);
        }
        return res;
    }


    public static void main(String[] args) {
        List<List<Integer>> A = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
        List<Integer> B = Arrays.asList(1, 2);
        List<Integer> C = Arrays.asList(1, 2);
        List<Integer> D = Arrays.asList(2, 3);
        List<Integer> E = Arrays.asList(2, 3);

        ArrayList<Integer> integers = new SubMatrixSumQueries().solve(A, B, C, D, E);
        System.out.println("integers = " + integers);

    }

}
