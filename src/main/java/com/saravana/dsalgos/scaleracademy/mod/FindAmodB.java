package com.saravana.dsalgos.scaleracademy.mod;

public class FindAmodB {

    public int findMod(String A, int B) {
        int multiple = 1;
        long ans = 0;
        char[] c = A.toCharArray();
        for(int i=c.length-1;i>=0;i--) {
            ans += ((long) (c[i] - 48) * multiple) % B;
            multiple = multiple * 10;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        new FindAmodB().findMod("878", 93);

    }
}
