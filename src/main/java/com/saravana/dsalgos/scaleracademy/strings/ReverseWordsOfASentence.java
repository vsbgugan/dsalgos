package com.saravana.dsalgos.scaleracademy.strings;

public class ReverseWordsOfASentence {

    public String solve(String A) {
        int n = A.length();
        char[] chars = A.toCharArray();
        for(int i=0, j = n-1;i<n/2;i++, j--) {
            char t = chars[i];
            chars[i] = chars[j];
            chars[j]  = t;
        }
        int l = 0;
        while(chars[l] == ' ') l++;
        int m = n -1;
        while(chars[m] == ' ') m--;

        char[] newChars = new char[n-l-(n-1-m)];
        int newIndex =0;
        while(l <= m) {
            int k = l;
            while(l <= m && chars[l] != ' ') l++;
            for(int i=l-1;i>=k;i--) {
                newChars[newIndex] = chars[i];
                newIndex++;
            }
            while(l <= m && chars[l] == ' ') {
                newChars[newIndex] = chars[l];
                newIndex++;
                l++;
            }
//            l++;
        }
        return new String(newChars);
    }

    public static void main(String[] args) {
        String solve = new ReverseWordsOfASentence().solve("crulgzfkif gg ombt vemmoxrgf qoddptokkz op xdq hv ");
        System.out.println("solve = " + solve);
    }
}
