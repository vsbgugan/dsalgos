/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saravana.dsalgos.scaleracademy.strings;

import java.util.Scanner;

/**
 *
 * @author ssundaram
 */
public class ReverseASentence {
    
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfTestCases = scanner.nextInt();
        for (int i = 0; i < noOfTestCases; i++) {
            String text = scanner.next();
            System.out.println(new String(reverseWords(text.toCharArray())));
        }

    }
    
    public static char[] reverseWords(char[] chs) {
        int startIndex = 0;
        for(int i=0;i<chs.length;i++) {
            if(chs[i]=='.') {
                reverse(chs, startIndex, i-1);
                startIndex = i+1;
            } else if(i == chs.length-1) {
                reverse(chs, startIndex, i);
            }
        }
        reverse(chs, 0, chs.length-1);
        return chs;       
    }
    
    public static void reverse(char[] chs, int startIndex, int endIndex) {
        final int length = (endIndex-startIndex+1)/2;
         for(int i=startIndex,j=0;i<startIndex+length;i++,j++) {
             swap(chs, i, endIndex-j);
        }
        
    }
    public static void swap(char[] chs, int left, int right) {
        char temp = chs[left];
        chs[left] = chs[right];
        chs[right] = temp;
    }
    
}
