package com.saravana.dsalgos.scaleracademy.strings;

public class FindLongestPalindromicSubstring {

//    public String longestPalindrome(String A) {
//        int n = A.length();
//        char[] chars = A.toCharArray();
//        int max = 1;
//        String longest = A.substring(0,1);
//        for(int start=0;start<n;start++) {
//            for(int end=start+1;end<n;end++) {
//                boolean isPalindrome = true;
//                for(int i=start, j=end; i <= j;i++,j--) {
//                    if(chars[i] != chars[j]) {
//                        isPalindrome = false;
//                        break;
//                    }
//                }
//                int len = end - start+1;
//                if(isPalindrome && len > max) {
//                    max = len;
//                    longest = A.substring(start, end+1);
//                }
//            }
//        }
//        return longest;
//    }

    public String longestPalindrome(String A) {
        int n = A.length() ;
        char[] chars = A.toCharArray();
        int max = Integer.MIN_VALUE;
        String sub = "";
        for (int i=0; i < n;i++) {
            int k = expand (chars,  i,  i);
            if(k > max) {
                max = k;
                int halfLen = k/2;
                sub = A.substring(i-halfLen,  i+halfLen+1);
            }
        }
        for (int i=0; i < n-1; i++) {
            int k = expand (chars,  i,  i+1);
            if(k > max) {
                max = k;
                int halfLen = (k/2)-1;
                sub = A.substring(i-halfLen,  (i+1)+halfLen+1);
            }
        }
        return sub;
    }

    public int expand(char[] chars, int p1,  int p2 ) {
        while (p1 >= 0 && p2 < chars.length && chars[p1] == chars[p2]) {
            p1--;
            p2++;
        }
        return p2 - p1 - 1;
    }

    public static void main(String[] args) {
        String answer = new FindLongestPalindromicSubstring().longestPalindrome("aaaabaaa");
//        String answer = new FindLongestPalindromicSubstring().longestPalindrome("abb");

        System.out.println("answer = " + answer);
    }
}
