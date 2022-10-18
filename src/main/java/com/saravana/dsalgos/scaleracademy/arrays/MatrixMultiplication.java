package com.saravana.dsalgos.scaleracademy.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixMultiplication {

    public ArrayList<ArrayList<Integer>> solve(List<List<Integer>> A, List<List<Integer>> B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int m = A.size();
        int n = A.get(0).size();
        int p = B.get(0).size();

        for(int i=0;i<m;i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for(int j=0;j<p;j++) {
                int sum = 0;
                for(int k=0;k<n;k++) {
                    sum += A.get(i).get(k) * B.get(k).get(j);
                }
                row.add(sum);
            }
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        new MatrixMultiplication().solve(Arrays.asList(List.of(94,91))
                , Arrays.asList(Arrays.asList(35, -52, -12, 26, -93, -61)
                        , Arrays.asList(29, -20, -36, -9, 66, 15)));
    }
}
