package com.saravana.dsalgos.scaleracademy.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {

    public ArrayList<Integer> solve(int A, List<Integer> B) {
        Queue<Integer> q = new PriorityQueue<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<A;i++) {
            q.offer(B.get(i));
            if(q.size() < A) {
                res.add(-1);
            }
        }
        int n = B.size();
        for(int i=A;i<n;i++) {
            if(q.peek() < B.get(i)) {
                res.add(q.remove());
                q.offer(B.get(i));
            } else {
                res.add(q.peek());
            }
        }
        res.add(q.peek());

        return res;
    }


    public static void main(String[] args) {
        ArrayList<Integer> solve = new KthLargestElement().solve(4, List.of(1, 2, 3, 4, 5, 6));
        System.out.println("solve = " + solve);
    }


}
