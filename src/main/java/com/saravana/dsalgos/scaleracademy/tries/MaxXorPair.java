package com.saravana.dsalgos.scaleracademy.tries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxXorPair {
    private static class Node {
        Node child0;
        Node child1;
    }

    private void insert(Node root, int num, int maxBits) {
        Node curr = root;
        for(int i=maxBits-1;i>=0;i--) {
            if((num & (1 << i)) != 0) {
                if(curr.child1==null){
                    curr.child1 = new Node();
                }
                curr = curr.child1;
            } else {
                if(curr.child0==null){
                    curr.child0 = new Node();
                }
                curr = curr.child0;
            }
        }
    }

    private int findNearestXorPair(Node root, int num, int maxBits) {
        Node curr = root;
        int xor = 0;
        for(int i=maxBits-1;i>=0;i--) {
            if((num & (1 << i)) != 0) { // if bit is 1
                if(curr.child0 != null) { // check for bit 0
                    xor += (1 << i);
                    curr = curr.child0;
                } else {
                    curr = curr.child1;
                }
            } else { // if bit is 0
                if(curr.child1 != null){
                    xor += (1 << i);
                    curr = curr.child1;
                } else {
                    curr = curr.child0;
                }
            }
        }
        return xor;
    }


    public int solve(List<Integer> A) {
        Node root = new Node();
        int max = Collections.max(A);

        int maxBits = max != 0 ? (int)(Math.ceil(Math.log(max) / Math.log(2))) : 0;

        // build the trie for all numbers
        for(int i: A) {
            insert(root, i, maxBits);
        }

        // search the trie for probable xor pair for each element
        int maxXor = Integer.MIN_VALUE;
        for(int i: A) {
            maxXor = Math.max(maxXor, findNearestXorPair(root, i, maxBits));
        }
        return maxXor;
    }

    public static void main(String[] args) {
//        int solve = new MaxXorPair().solve(List.of(1, 2, 3, 4, 5));
        int solve = new MaxXorPair().solve(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        System.out.println("solve = " + solve);
    }



}
