package com.saravana.dsalgos.scaleracademy.arrays;

public class CountOfAGSubsequence {
    public int solve(String A) {
        char[] c = A.toCharArray();
        int subseqCount = 0;
        int countOfG = 0;
        int n = c.length;
        for(int i=n-1;i> 0;i--) {
            if(c[i] == 'G') {
                countOfG++;
            }
            if(c[i] == 'A') {
                subseqCount += countOfG;
            }
        }
        return subseqCount;
    }

    public static void main(String[] args) {
        int count = new CountOfAGSubsequence().solve("AAEYETGGA");
        System.out.println("count = " + count);
    }
}
