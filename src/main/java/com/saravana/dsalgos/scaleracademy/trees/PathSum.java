package com.saravana.dsalgos.scaleracademy.trees;


public class PathSum {

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

    private static class PairSum {
        int sum;
        boolean isSum;
        PairSum(int sum, boolean isSum) {
            this.sum = sum;
            this.isSum = isSum;
        }
    }

    public int hasPathSum(TreeNode A, int B) {
        PairSum res = hasPathSumUtil(A, B, 0);
        return res.isSum ? 1 : 0;
    }

    public PairSum hasPathSumUtil(TreeNode A, int B, int sum) {
        if(A == null) return new PairSum(sum, false);
        sum += A.val;
        if(sum == B) return new PairSum(sum, true);
        else {
            PairSum leftSum = hasPathSumUtil(A.left, B, sum);
            if(leftSum.isSum) return leftSum;
            PairSum rightSum = hasPathSumUtil(A.right, B, sum);
            if(rightSum.isSum) return rightSum;
            return new PairSum(sum - A.val, false);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1000);
        root.right = new TreeNode(200);
        int i = new PathSum().hasPathSum(root, 1000);
        System.out.println("i = " + i);

    }
}
