package com.saravana.dsalgos.scaleracademy.tries;

import java.util.ArrayList;
import java.util.List;

public class ValidPhoneDirectory {
    private static class Node {
        Node[] children = new Node[10];
        boolean isEnd = false;
    }

    private boolean insert(Node root, String s) {
        Node curr = root;
        boolean isPrefix = false;
        int n = s.length();
        for(int i=0;i<n;i++) {
            int idx = s.charAt(i) - '0';
            if(curr.children[idx] == null) {
                if(curr.isEnd) isPrefix = true;
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
        return isPrefix;
    }

    public int solve(List<String> A) {
        Node root = new Node();
        for(String s: A) {
            if(insert(root, s)) {
                return 0;
            };
        }
        return 1;
    }

    public static void main(String[] args) {
        int solve = new ValidPhoneDirectory().solve(List.of("1234", "1234"));
        System.out.println("isValid = " + (solve == 1));

    }

}
