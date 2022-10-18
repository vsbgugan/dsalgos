package com.saravana.dsalgos.scaleracademy.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonElements {

    public ArrayList<Integer> solve(List<Integer> A, List<Integer> B) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for(Integer i: A) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }
        for(Integer i: B) {
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }
        for(Integer i: A) {
            if(map2.containsKey(i) && map2.get(i).equals(map1.get(i))) {
                int count = map2.get(i);
                for(int k=0;k<count;k++) {
                    results.add(i);
                }
            }
        }
        return results;
    }


    public static void main(String[] args) {
        new CommonElements().solve(List.of(1, 2, 2, 1), List.of(2, 3, 1, 2 ));
    }
}
