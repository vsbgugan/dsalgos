package com.saravana.dsalgos.scaleracademy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FindIfArithmeticProgression {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        if(A.size() < 2) return 0;
        int prev = A.get(1);
        int diff = A.get(1) - A.get(0);
        for(int i=2;i<A.size();i++) {
            int current = A.get(i);
            if((current  - prev ) != diff) {
                return 0;
            }
        }
        return 1;

    }

    public static void main(String[] args) {
        ArrayList<Integer> values = new ArrayList<>();
//        values.addAll(Arrays.asList( -4, 7, 5, 3, 5, -4, 2, -1, -9, -8, -3, 0, 9, -7, -4, -10, -4, 2, 6, 1, -2, -3, -1, -8, 0, -8, -7, -3, 5, -1, -8, -8, 8, -1, -3, 3, 6, 1, -8, -1, 3, -9, 9, -6, 7, 8, -6, 5, 0, 3, -4, 1, -10, 6, 3, -8, 0, 6, -9, -5, -5, -6, -3, 6, -5, -4, -1, 3, 7, -6, 5, -8, -5, 4, -3, 4, -6, -7, 0, -3, -2, 6, 8, -2, -6, -7, 1, 4, 9, 2, -10, 6, -2, 9, 2, -4, -4, 4, 9, 5, 0, 4, 8, -3, -9, 7, -8, 7, 2, 2, 6, -9, -10, -4, -9, -5, -1, -6, 9, -10, -1, 1, 7, 7, 1, -9, 5, -1, -3, -3, 6, 7, 3, -4, -5, -4, -7, 9, -6, -2, 1, 2, -1, -7, 9, 0, -2, -2, 5, -10, -1, 6, -7, 8, -5, -4, 1, -9, 5, 9, -2, -6, -2, -9, 0, 3, -10, 4, -6, -6, 4, -3, 6, -7, 1, -3, -5, 9, 6, 2, 1, 7, -2, 5 ));
        values.addAll(Arrays.asList(-251, -305, -323, -53, -215, -143, -107, -161, -179, -431, -449, -17, -341, -413, -35, -125, -197, -377, -269, -71, -359, -89, -233, -287, -395));
        System.out.println(new FindIfArithmeticProgression().solve(values));
    }
}
