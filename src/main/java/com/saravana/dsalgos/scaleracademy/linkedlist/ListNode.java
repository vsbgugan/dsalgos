package com.saravana.dsalgos.scaleracademy.linkedlist;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode(int x, ListNode nextN) {
        val = x;
        next = nextN;
    }

}