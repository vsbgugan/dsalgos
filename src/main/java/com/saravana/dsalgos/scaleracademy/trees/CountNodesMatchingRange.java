package com.saravana.dsalgos.scaleracademy.trees;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;

public class CountNodesMatchingRange {

    private static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }


    public int solve(TreeNode A, int B, int C) {
        int count = 0;
        if(A == null) return 0;
        if(A.val > B && A.val < C) {
            count = 1 + solve(A.left, B, C) + solve(A.right, B, C);
        } else if(A.val == B) {
            count = 1 + solve(A.right, B, C);
        } else if(A.val == C) {
            count = 1 + solve(A.left, B, C);
        }
        return count;
    }

    public static void main(String[] args) {
//        TreeNode node8 = new TreeNode(8);
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node21 = new TreeNode(21);
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node7 = new TreeNode(7);
//        node8.left = node6;
//        node8.right = node21;
//        node6.left = node1;
//        node6.right = node7;

        TreeNode node15 = new TreeNode(15);
        TreeNode node12 = new TreeNode(12);
        TreeNode node20 = new TreeNode(20);
        TreeNode node10 = new TreeNode(10);
        TreeNode node14 = new TreeNode(14);
        TreeNode node16 = new TreeNode(16);
        TreeNode node27 = new TreeNode(27);
        TreeNode node8 = new TreeNode(8);

        node15.left = node12;
        node15.right = node20;
        node12.left = node10;
        node12.right = node14;
        node20.left = node16;
        node20.right = node27;
        node10.left = node8;

        int solve = new CountNodesMatchingRange().solve(node15, 12, 20);
        System.out.println("solve = " + solve);


    }


}
