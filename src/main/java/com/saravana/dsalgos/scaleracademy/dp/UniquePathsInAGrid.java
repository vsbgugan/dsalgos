package com.saravana.dsalgos.scaleracademy.dp;

import java.util.ArrayList;
import java.util.List;

public class UniquePathsInAGrid {
    public int uniquePathsWithObstacles(List<List<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                dp[i][j] = -1;
            }
        }
        ways(dp, A, n-1, m-1);
        return dp[n-1][m-1];

    }

    private int ways(int[][] dp, List<List<Integer>> arr, int i, int j) {
        if(i < 0 || j < 0) return 0;
        if(i ==0 && j == 0) return arr.get(i).get(j) == 1 ? 0 : 1;
        if(dp[i][j] != -1) return dp[i][j];
        dp[i][j] = arr.get(i).get(j) == 1 ? 0 : ways(dp, arr, i-1, j) + ways(dp, arr, i, j-1);
        return dp[i][j];
    }

    public static void main(String[] args) {
        int i = new UniquePathsInAGrid().uniquePathsWithObstacles(List.of(List.of(0)));
        System.out.println("i = " + i);
    }



}
