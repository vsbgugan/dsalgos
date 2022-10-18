package com.saravana.dsalgos.scaleracademy.bits;

public class HelpFromSum {
    public int solve(int A) {
        if(A == 0) return 0;
//        return A % 2 == 0 ? 1 : 2;
        int nearestPower = 0;
        for(int i=Integer.SIZE-1; i>=0;i++) {
            if((A & (1 << i)) != 0) {
                nearestPower = (1 << i);
                break;
            }
        }
        return A - nearestPower + 1;
    }


    public static void main(String[] args) {
        new HelpFromSum().solve(7);
    }


}
