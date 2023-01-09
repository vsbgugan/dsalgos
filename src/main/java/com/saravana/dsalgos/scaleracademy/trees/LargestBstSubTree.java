package com.saravana.dsalgos.scaleracademy.trees;

public class LargestBstSubTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }


    public int solve(TreeNode A) {
        return isValidBSTUtil(A, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int isValidBSTUtil(TreeNode root, int min, int max) {
        if(root == null) return -2;
        if(root.val >= min && root.val <= max) {
            int left = isValidBSTUtil(root.left, min, root.val - 1);
            int right = isValidBSTUtil(root.right, root.val + 1, max);
            int size = 0;
            if(left == -2 && right == -2) return 1;
            if(left == -1 && right == -1) {
                size = -1;
            } else if(left == -1 && right != -1) {
                size = -1;
            } else if(left != -1 && right == -1) {
                size = -1;
            } else {
                size = left + right + 1;
            }
            return size;
        } else return -1;
    }


    public static void main(String[] args) {
        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node15 = new TreeNode(15);
        TreeNode node1 = new TreeNode(1);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);

        node10.left = node5;
        node10.right = node15;
        node5.left = node1;
        node5.right = node8;
        node15.right = node7;

        int solve = new LargestBstSubTree().solve(node10);
        System.out.println("solve = " + solve);

    }
}
