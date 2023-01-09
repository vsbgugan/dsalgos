package com.saravana.dsalgos.scaleracademy.stacks;

import java.util.Stack;

public class InfixToPostfix {

    public String solve(String A) {
        int n = A.length();
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<n;i++) {
            char c = A.charAt(i);
            if(isOperand(c)) {
                res.append(c);
            } else if(isOperator(c)) {
                while(!st.empty() && st.peek() != '(' && hasHigherPrecedence(st.peek(), c)) {
                    res.append(st.pop());
                }
                st.push(c);
            } else if(c == '(') {
                st.push(c);
            } else if(c == ')') {
                while(!st.empty() && st.peek() != '(') {
                    res.append(st.pop());
                }
                st.pop(); // just pop the '('
            }
        }
        while(!st.empty()) {
            res.append(st.pop());
        }
        return res.toString();
    }

    public boolean isOperator(char c) {
        if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
            return true;
        } else return false;
    }

    public boolean isOperand(char c) {
        if(c >= '0' && c <= '9') return true;
        else if(c >= 'a' && c <= 'z') return true;
        else if(c >= 'A' && c <= 'Z') return true;
        else return false;
    }

    public boolean isLeftAssociative(char c) {
        if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
            return true;
        } else return false; // in case of ^
    }

    public boolean hasHigherPrecedence(char op1, char op2) {
        int w1 = getWeight(op1);
        int w2 = getWeight(op2);
        if(w1 == w2) {
            return isLeftAssociative(op1);
        } else {
            return w1 > w2;
        }
    }

    public int getWeight(char op) {
        switch(op) {
            case '+' :
            case '-' : return 1;
            case '*' :
            case '/' : return 2;
            case '^' : return 3;
        }
        return -1;
    }

    public static void main(String[] args) {
        InfixToPostfix instance = new InfixToPostfix();
        String solve = instance.solve("c*(u-p)^e/(w*x^p)^k^(d^o)");
        System.out.println("solve = " + solve);
    }


}
