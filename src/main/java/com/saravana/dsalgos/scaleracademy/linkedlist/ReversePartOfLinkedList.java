package com.saravana.dsalgos.scaleracademy.linkedlist;

public class ReversePartOfLinkedList {


    public ListNode reverseBetween(ListNode A, int B, int C) {
        int counter = 1;
        ListNode nodePrevB = null;
        ListNode nodeB = A;
        while(nodeB != null && counter < B-1) {
            nodePrevB = nodeB;
            nodeB = nodeB.next;
            counter++;
        }

        int reverseCounter = C - B;
        ListNode prev = nodeB;
        ListNode curr = nodeB.next;
        while(curr != null && reverseCounter >= 1) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            reverseCounter--;
        }
        nodeB.next = curr;

        if(nodePrevB != null) {
            nodePrevB.next = prev;
        }

        return B == 1 ? prev : A;
    }


    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        new ReversePartOfLinkedList().reverseBetween(node1, 2, 3);


    }
}
