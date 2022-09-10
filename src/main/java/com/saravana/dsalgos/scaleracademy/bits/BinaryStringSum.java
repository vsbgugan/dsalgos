package com.saravana.dsalgos.scaleracademy.bits;

public class BinaryStringSum {
    private int parse(char c) {
        return c == '0' ? 0 : 1;
    }
    public String addBinary(String A, String B) {
        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();

        int maxLen = Math.max(A.length(), B.length());
        int diff = Math.abs(A.length()- B.length());
        int carryForward = 0;
        StringBuilder ans = new StringBuilder();
        for(int i=maxLen-1;i>=0;i--) {
            int digitOfA = (maxLen != charsA.length ? i-diff < 0 ? 0 : parse(charsA[i-diff]): parse(charsA[i]));
            int digitOfB = (maxLen != charsB.length ? i-diff < 0 ? 0 : parse(charsB[i-diff]): parse(charsB[i]));
            int currentSum = carryForward +  digitOfA + digitOfB;
            int currentDigit = currentSum % 2;
            ans.insert(0, currentDigit);
            carryForward = currentSum / 2;
        }
//        ans.insert(0, carryForward);
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = new BinaryStringSum().addBinary("1010110111001101101000", "1000011011000000111100110");
        System.out.println("s = " + s);
    }
}
//1001110001111010101001110
 //001110001111010101001110