package com.saravana.dsalgos.scaleracademy.linkedlist;

import java.util.Scanner;

public class LinkedListOperations {


    static class Node {
        private int value;
        private Node next;
        Node(int value) {
            this.value = value;
        }
    }

    public static Node head = null;

    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer

        Node x = new Node(value);
        if(position == 1) {
            x.next = head;
            head = x;
            return;

        } else {
            int counter = 1;
            Node temp = head;
            while(temp != null && counter != position-1) {
                temp = temp.next;
                counter++;
            }
            if(temp != null) {
                Node next = temp.next;
                temp.next = x;
                x.next = next;
            }
        }
    }

    public static void delete_node(int position) {
        // @params position, integer
        if(position == 1) {
            head = head.next;
            return;
        } else {
            int counter = 1;
            Node temp = head;
            while(temp != null && counter != position-1) {
                temp = temp.next;
                counter++;

            }
            temp.next = temp.next.next;
        }

    }

    public static void print_ll() {
        // Output each element followed by a space
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i=0;i<t;i++) {
          String op = sc.next();
          if(op.equals("i")) {
              int position = sc.nextInt();
              int value = sc.nextInt();
              insert_node(position, value);
          } else if(op.equals("p")) {
              print_ll();
          } else if(op.equals("d")) {
              int position = sc.nextInt();
              delete_node(position);
          }
        }
    }



}
