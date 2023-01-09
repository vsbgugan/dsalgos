package com.saravana.dsalgos.scaleracademy.heaps;

import java.util.*;

public class ProductOf3 {
    public ArrayList<Integer> solve(List<Integer> A) {
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        // for(int i: A) {
        //     q.offer(i);
        // }
        int n = A.size();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=1;i<=n;i++) {
            if(i < 3) {
                q.offer(A.get(i-1));
                res.add(-1);
            } else {
                q.offer(A.get(i-1));
                int a = q.peek();
                int b = q.peek();
                int c = q.peek();
                res.add(a * b * c);
                // q.offer(a);
                // q.offer(b);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new ProductOf3().solve(List.of(1, 2, 3, 4, 5));
    }
}
