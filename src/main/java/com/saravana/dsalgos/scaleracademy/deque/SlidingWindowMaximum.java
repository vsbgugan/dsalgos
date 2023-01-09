package com.saravana.dsalgos.scaleracademy.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public int[] slidingMaximum(final int[] A, int B) {
        Deque<Integer> deck = new ArrayDeque<>();
        int n = A.length;
        int[] res = new int[n-B+1];
        for(int i=0;i<B;i++) {
            if(deck.size() == 0) {
                deck.addLast(A[i]);
            } else {
                while(deck.peekLast() != null && deck.peekLast() < A[i]) {
                    deck.removeLast();
                }
                deck.addLast(A[i]);
            }
        }
        int k = 0;
        res[0] = deck.getFirst();

        for(int i=B;i<n;i++)  {
            int outgoingELem = A[i-B];
            int incomingElem = A[i];
            while(deck.peekLast() != null && deck.peekLast() < incomingElem) {
                deck.removeLast();
            }
            deck.addLast(A[i]);
            if(deck.peekFirst() != null && deck.peekFirst() == outgoingELem) {
                deck.removeFirst();
            }
            res[i-B+1] = deck.getFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        new SlidingWindowMaximum().slidingMaximum(new int[] {  648, 614, 490, 138, 657, 544, 745, 582, 738, 229, 775, 665, 876, 448, 4, 81, 807, 578, 712, 951, 867, 328, 308, 440, 542, 178, 637, 446, 882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207, 368 }, 9);
    }



}
