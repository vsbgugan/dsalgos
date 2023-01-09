package com.saravana.dsalgos.scaleracademy.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {

    public ArrayList<ArrayList<String>> solveNQueens(int A) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        int n = A;
        boolean[] col = new boolean[n];
        boolean[] diag = new boolean[(n*2)-1];
        boolean[] antiDiag = new boolean[(n*2)-1];
        Arrays.fill(col, true);
        Arrays.fill(diag, true);
        Arrays.fill(antiDiag, true);
        nQueens(0, n, col, diag, antiDiag, res, new int[n][n]);
        return res;
    }

    private void nQueens(int row, int n, boolean[] col, boolean[] diag, boolean[] antiDiag, ArrayList<ArrayList<String>> res, int[][] board) {
        if(row == n) {
            ArrayList<String> convRes = new ArrayList<>();
            for(int i=0;i<n;i++) {
                char[] chars = new char[n];
                for(int j=0;j<n;j++) {
                    chars[j] = (board[i][j] == 1 ? 'Q' : '.');
                }
                convRes.add(new String(chars));
            }
            res.add(convRes);
        }
        for(int j=0;j<n;j++) {
            if(!col[j] || !diag[row - j + n - 1] || !antiDiag[row + j]) {
                continue;
            }
            board[row][j] = 1;
            col[j] = false;
            diag[row-j+n-1] = false;
            diag[row+j] = false;
            nQueens(row+1, n, col, diag, antiDiag, res, board);
            board[row][j] = 0;
            col[j] = true;
            diag[row-j+n-1] =true;
            diag[row+j] = true;
        }
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<String>> arrayLists = new NQueens().solveNQueens(2);
        System.out.println("arrayLists = " + arrayLists);

    }





}
