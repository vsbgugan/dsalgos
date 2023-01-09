package com.saravana.dsalgos.scaleracademy.heaps;

import java.util.*;

public class ConnectRopes {
    public int solve(List<Integer> A) {
        Queue<Integer> q = new PriorityQueue<>(A);
        int ans = 0;
        while(!q.isEmpty()) {
            int a = q.remove();
            int b = q.remove();
            int sum = a + b;
            ans += sum;
            if(!q.isEmpty()) {
                q.offer(sum);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
//        int solve = new ConnectRopes().solve(List.of(16, 7, 3, 5, 9, 8, 6, 15));
        int solve = new ConnectRopes().solve(List.of(1, 18));

        System.out.println("solve = " + solve);
    }

}
