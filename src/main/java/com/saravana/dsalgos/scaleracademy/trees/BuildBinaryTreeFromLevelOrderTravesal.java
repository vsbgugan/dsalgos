package com.saravana.dsalgos.scaleracademy.trees;

import java.util.Arrays;
import java.util.List;

public class BuildBinaryTreeFromLevelOrderTravesal {

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

    public TreeNode solve(List<Integer> A) {
        if(A.size() ==0) return null;
        return solve(A, 0);
    }

    public TreeNode solve(List<Integer> A, int i) {
//        if(i == -1 || i >= A.size()) return null;
        if(i >= A.size() || A.get(i) == -1) return null;
        TreeNode node = new TreeNode(A.get(i));
        node.left = solve(A, (2*i)+1);
        node.right = solve(A, (2*i)+2);
        return node;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new BuildBinaryTreeFromLevelOrderTravesal().solve(Arrays.asList(1, 2, 4, -1, 3, -1, 5, 7, -1, -1, 6, -1, 8, -1, -1, -1, -1));
        System.out.println("treeNode = " + treeNode);
    }

}
