package com.saravana.dsalgos.scaleracademy.dp;

public class EditDistance {

    public int minDistance(String A, String B) {
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n][m];
        md(n-1, m-1, dp, A, B);
        return dp[n-1][m-1];
    }

    private int md(int i, int j, int[][] dp, String A, String B) {
        if(i < 0 && j < 0) {
            return 0;
        }
        if(i < 0) {
            return j+1;
        }
        if(j < 0) {
            return i+1;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(A.charAt(i) == B.charAt(j)) {
            dp[i][j] = md(i-1, j-1, dp, A, B);
        } else {
            dp[i][j] = Math.min(1 + md(i, j-1, dp, A, B),
                    Math.min(
                            1 + md(i-1, j, dp, A, B),
                            1 + md(i-1, j-1, dp, A, B)));
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        int i = new EditDistance().minDistance("a", "b");
        System.out.println("i = " + i);
    }

}
