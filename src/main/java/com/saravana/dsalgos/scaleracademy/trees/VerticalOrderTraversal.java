package com.saravana.dsalgos.scaleracademy.trees;


import java.util.*;

public class VerticalOrderTraversal {

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

    private static class NodeDistance {
        TreeNode node;
        int dist;

        NodeDistance(TreeNode node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {

        Queue<NodeDistance> q = new LinkedList<>();
        q.offer(new NodeDistance(A, 0));

        Map<Integer, List<TreeNode>> map = new HashMap<>();

        int min = 0;
        int max = 0;

        while(!q.isEmpty()) {

            NodeDistance nodeDistance = q.remove();
            TreeNode node = nodeDistance.node;
            int dist = nodeDistance.dist;
            List<TreeNode> list = map.getOrDefault(dist, new ArrayList<TreeNode>());
            list.add(node);
            map.put(dist, list);
            if(node.left != null) {
                q.offer(new NodeDistance(node.left, dist - 1));
                min = Math.min(min, dist - 1);
            }
            if(node.right != null) {
                q.offer(new NodeDistance(node.right, dist + 1));
                max = Math.max(max, dist + 1);
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int i=min;i<=max;i++) {
            if(map.get(i).size() > 0) {
                ArrayList<Integer> level = new ArrayList<>();
                res.add(level);
                for(TreeNode node: map.get(i)) {
                    level.add(node.val);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(6);
        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node9 = new TreeNode(9);

//        node6.left = node3;
//        node6.right = node7;
//        node3.left = node2;
//        node3.right = node5;
//        node7.right = node9;

        node6.left = node3;
//        node6.right = node7;
        node3.left = node2;
//        node2.left = node5;
//        node7.right = node9;

        ArrayList<ArrayList<Integer>> arrayLists = new VerticalOrderTraversal().verticalOrderTraversal(node6);
        System.out.println("arrayLists = " + arrayLists);
    }


}
