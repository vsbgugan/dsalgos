package com.saravana.dsalgos.scaleracademy.hashing;

import java.util.HashSet;
import java.util.List;

public class DiffPossible {

    public int diffPossible(final List<Integer> A, int B) {
        HashSet<Integer> set = new HashSet<>();
        for(int i: A) {
            if(set.contains(B+i)) return 1;
            else set.add(i);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for(int i=A.size()-1;i>=0;i--) {
            int elem = A.get(i);
            if(set2.contains(B+elem)) return 1;
            else set2.add(i);
        }
        return 0;
    }


    public static void main(String[] args) {
        new DiffPossible().diffPossible(List.of(1, 3, 2), 0);
    }
}
