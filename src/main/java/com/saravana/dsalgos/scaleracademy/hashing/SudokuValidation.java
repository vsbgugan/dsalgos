package com.saravana.dsalgos.scaleracademy.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
The input corresponding to the above configuration :

["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
A partially filled sudoku which is valid.

Note:

A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class SudokuValidation {

    public int isValidSudoku(final List<String> A) {
        int n = 9;
        // check row wise
        for(int i=0;i<n;i++) {
            Set<Character> rowSet = new HashSet();
            for(int j=0;j<n;j++) {
                char curr = A.get(i).charAt(j);
                if(curr == '.') continue;
                if(!rowSet.add(curr)) {
                    return 0;
                }
            }
        }
        // check column wise
        for(int j=0;j<n;j++) {
            Set<Character> colSet = new HashSet();
            for(int i=0;i<n;i++) {
                char curr = A.get(i).charAt(j);
                if(curr == '.') continue;
                if(!colSet.add(curr)) {
                    return 0;
                }
            }
        }
        // check cube wise
        for(int l=0;l<9;l+=3) {
            for(int m=0;m<9;m+=3) {
                Set<Character> cubeSet = new HashSet();
                for(int i=l;i<l+3;i++) {
                    for(int j=m;j<m+3;j++) {
                        char curr = A.get(i).charAt(j);
                        if(curr == '.') continue;
                        if(!cubeSet.add(curr)) {
                            return 0;
                        }
                    }
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        List<String> sudokuBoard = Arrays.asList("..5.....6", "....14...", ".........", ".....92..", "5....2...", ".......3.", "...54....", "3.....42.", "...27.6.." );
        new SudokuValidation().isValidSudoku(sudokuBoard);
    }


}
