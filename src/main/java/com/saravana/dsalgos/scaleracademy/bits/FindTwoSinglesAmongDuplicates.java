package com.saravana.dsalgos.scaleracademy.bits;

import java.util.*;

public class FindTwoSinglesAmongDuplicates {

    // Approach - 1 , Sort and check if the two consecutive numbers are same, if they are not, then it appears only once
    // T.C - O(N Log N)
    // S.C - O(N)
    public ArrayList<Integer> solveBySorting(List<Integer> A) {
        Collections.sort(A);
        ArrayList<Integer> res = new ArrayList<>();
        int prev = -1;
        for(int i=0;i<A.size();i++) {
            int curr = A.get(i);
            if(prev == -1)  {
                prev = curr;
                continue;
            } else {
                if(prev != curr) {
                    res.add(prev);
                    prev = curr;
                } else {
                    prev = -1;
                }
            }

        }
        if(prev != -1) res.add(prev);
        return res;
    }

    public ArrayList<Integer> solveByFreqHashing(List<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int i : A) {
            int count = freqMap.getOrDefault(i, 0);
            freqMap.put(i, ++count);
        }
        freqMap.forEach((x, y) -> {
            if(y == 1) {
                ans.add(x);
            }
        });
        return ans;
    }



    public static void main(String[] args) {
        new FindTwoSinglesAmongDuplicates().solveByFreqHashing(Arrays.asList(186, 256, 102, 377, 186, 377));
//        new FindTwoSinglesAmongDuplicates().solveByFreqHashing(Arrays.asList(408, 478, 74, 624, 74, 204, 705, 624, 337, 408, 478, 204));
    }

}
