package com.saravana.dsalgos.scaleracademy.linkedlist;

public class SortLinkedList {

    public ListNode sortList(ListNode A) {
        if(A == null || A.next == null) return A;
        ListNode middle = middle(A);
        ListNode right = middle.next;
        middle.next = null;
        ListNode left = A;
        left = sortList(left);
        right = sortList(right);
        return mergeTwoLists(left, right);
    }

    public ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head != null && head.next != null) {
            return  head; // in case of size 2, return the first element as middle to avoid stack overflow
        }
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode h1 = A;
        ListNode h2 = B;
        ListNode h3 = new ListNode(-1);
        ListNode tail = h3;

        while(h1 != null && h2 != null) {
            if(h1.val < h2.val) {
                tail.next = h1;
                h1 = h1.next;
                tail = tail.next;
            } else {
                tail.next = h2;
                h2 = h2.next;
                tail = tail.next;
            }
        }
        if(h1 != null) tail.next = h1;
        if(h2 != null) tail.next = h2;
        h3 = h3.next;
        return h3;
    }

    public static void main(String[] args) {
        ListNode n5 = new ListNode(4, null);
        ListNode n4 = new ListNode(2, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(1, n3);
        ListNode n1 = new ListNode(5, n2);

        ListNode listNode = new SortLinkedList().sortList(n1);
        System.out.println("listNode = " + listNode);

    }



}
