package com.saravana.dsalgos.scaleracademy.trees;

import java.util.*;

public class BuildBinaryTreeFromInOrderAndPostOrder {

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


    public TreeNode buildTree(List<Integer> A, List<Integer> B) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i=0;i<A.size();i++) {
            inMap.put(A.get(i), i);
        }
        return buildUtil(inMap, A, B, 0, A.size()-1, 0, B.size()-1);
    }


    public TreeNode buildUtil(Map<Integer, Integer> inMap, List<Integer> in, List<Integer> post, int inStart, int inEnd, int postStart, int postEnd) {
        if(inStart > inEnd) return null;
        int rootVal = post.get(postEnd);
        int rootIndex = inMap.get(rootVal);
        TreeNode node = new TreeNode(rootVal);
        int postMid = postStart+rootIndex-1-inStart;
        node.left = buildUtil(inMap, in, post, inStart, rootIndex-1, postStart, postMid);
        node.right = buildUtil(inMap, in, post, rootIndex+1, inEnd, postMid+1, postEnd-1);
        return node;
    }

    public static void main(String[] args) {
        new BuildBinaryTreeFromInOrderAndPostOrder().buildTree(Arrays.asList(7, 5, 6, 2, 3, 1, 4), Arrays.asList(5, 6, 3, 1, 4, 2, 7));
    }

}
