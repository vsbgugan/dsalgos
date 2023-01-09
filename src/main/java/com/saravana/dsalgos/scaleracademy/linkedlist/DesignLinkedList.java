package com.saravana.dsalgos.scaleracademy.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DesignLinkedList {


    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode head = null;

    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer

        ListNode x = new ListNode(value);
        if(position == 1) {
            x.next = head;
            head = x;
            return;

        } else if(position == -1) { // append to the end
            ListNode temp = head;
            if(temp == null) {
                head = x;
            } else {
                while(temp.next != null) {
                    temp = temp.next;
                }
                temp.next = x;
            }
        } else {
            int counter = 1;
            ListNode temp = head;
            while(temp != null && counter != position-1) {
                temp = temp.next;
                counter++;
            }
            if(temp != null) {
                ListNode next = temp.next;
                temp.next = x;
                x.next = next;
            }
        }
    }

    public static void delete_node(int position) {
        // @params position, integer
        if(position == 1 && head != null) {
            head = head.next;
            return;
        } else {
            int counter = 1;
            ListNode temp = head;
            while(temp != null && counter != position-1) {
                temp = temp.next;
                counter++;

            }
            if(temp != null && temp.next != null) {
                temp.next = temp.next.next;
            }
        }

    }



    public ListNode solve(List<List<Integer>> A) {
        for(List<Integer> t : A) {
            int op = t.get(0);
            int val = t.get(1);
            int position = t.get(2);
            if(op == 0) {
                insert_node(1, val);
            } else if(op == 1) {
                insert_node(-1, val);
            } else if(op == 2) {
                insert_node(position+1, val);
            } else if(op == 3) {
                delete_node(val+1); // in case of 3, val is index
            }
        }
        return head;
    }

    public static void main(String[] args) {
        List<List<Integer>> ops = Arrays.asList(
                Arrays.asList(2, 18, 0),
                Arrays.asList(2, 5, 1),
                Arrays.asList(2, 8, 0),
                Arrays.asList(1, 7, -1),
                Arrays.asList(1, 5, -1));

//        List<List<Integer>> ops = Arrays.asList(
//                Arrays.asList(1, 13, -1),
//                Arrays.asList(3, 0, -1),
//                Arrays.asList(3, 1, -1),
//                Arrays.asList(2, 15, 0),
//                Arrays.asList(3, 0, -1),
//                Arrays.asList(1, 12, -1),
//        Arrays.asList(3, 0, -1),
//        Arrays.asList(1, 19, -1),
//        Arrays.asList(1, 13, -1),
//        Arrays.asList(3, 0, -1),
//        Arrays.asList(0, 12, -1),
//        Arrays.asList(1, 13, -1),
//        Arrays.asList(3, 2, -1));
        new DesignLinkedList().solve(ops);
    }

}
