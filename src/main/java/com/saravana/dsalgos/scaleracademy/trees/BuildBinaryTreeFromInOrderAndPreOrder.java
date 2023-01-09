package com.saravana.dsalgos.scaleracademy.trees;

import java.util.*;

public class BuildBinaryTreeFromInOrderAndPreOrder {

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


    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i=0;i<A.size();i++) {
            inMap.put(A.get(i), i);
        }
        return buildUtil(inMap, A, B, 0, A.size()-1, 0, B.size()-1);
    }


    public TreeNode buildUtil(Map<Integer, Integer> inMap, ArrayList<Integer> in, ArrayList<Integer> pre, int inStart, int inEnd, int preStart, int preEnd) {
        if(inStart > inEnd) return null;
        int rootVal = pre.get(preStart);
        int rootIndex = inMap.get(rootVal);
        TreeNode node = new TreeNode(rootVal);
        int preMid = preStart+1+(rootIndex-1)-inStart;
        node.left = buildUtil(inMap, in, pre, inStart, rootIndex-1, preStart+1, preMid);
        node.right = buildUtil(inMap, in, pre, rootIndex+1, inEnd, preMid+1, preEnd);
        return node;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.addAll(Arrays.asList(1, 2, 4, 5, 3, 6, 7));
        ArrayList<Integer> B = new ArrayList<>();
        B.addAll(Arrays.asList(4, 2, 5, 1, 6, 3, 7));
        TreeNode treeNode = new BuildBinaryTreeFromInOrderAndPreOrder().buildTree(A, B);

    }


}
