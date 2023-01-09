package com.saravana.dsalgos.scaleracademy.tries;

import java.util.*;
import java.util.stream.Collectors;

public class AutoComplete {

    private static class Node {
        Node[] children = new Node[26];
        boolean isEnd = false;
        List<Integer> weights = null;

        int childCount = 0;
    }

    private  static class WordWeight {
        String word;
        Integer weight;
    }

    private static void insert(Node root, String s, int weight) {
        Node curr = root;
        int n = s.length();
        for(int i=0;i<n;i++) {
            int idx = s.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
                curr.childCount++;
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
//        curr.count++;
        if(curr.weights == null) curr.weights = new ArrayList<>();
        curr.weights.add(weight);
    }

    private static List<String> findWordsWithPrefix(Node root, String pf) {
        Node curr = root;
        int n = pf.length();
//        List<String> words = new ArrayList<String>();
        List<WordWeight> wordWeights = new ArrayList<>();
        for(int i=0;i<n;i++) {
            int idx = pf.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                return Collections.EMPTY_LIST;
            }
            curr = curr.children[idx];
        }
//        if(c)
        if (curr.isEnd) {
            for(Integer w : curr.weights) {
                WordWeight wordWeight = new WordWeight();
                wordWeight.word = pf;
                wordWeight.weight = w;
                wordWeights.add(wordWeight);
            }
        }

        traverse(pf, wordWeights, curr);
        // Collections.sort
        Collections.sort(wordWeights, new Comparator<WordWeight>() {
            @Override
            public int compare(WordWeight o1, WordWeight o2) {
                return o2.weight.compareTo(o1.weight);
            }
        });
        List<String> words = wordWeights.stream().map(x -> x.word).collect(Collectors.toList());
        return words;
    }

    public static void traverse(String pf, List<WordWeight> words, Node node) {
        for (int i = 0; i < node.children.length; i++) {
            Node child = node.children[i];
            if (child != null) {
                char ch = (char) ('a' + i);
                String newPf = pf + ch;
                if (child.isEnd) {
                    for(Integer w : child.weights) {
                        WordWeight wordWeight = new WordWeight();
                        wordWeight.word = newPf;
                        wordWeight.weight = w;
                        words.add(wordWeight);
                    }
                }
                if(child.childCount > 0) {
                    traverse(newPf, words, child);
                }
            }
        }
    }


    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++) {
            Node root = new Node();
            int n = sc.nextInt();
            int m = sc.nextInt();
            String[] dict = new String[n];
            for(int j=0;j<n;j++) {
                dict[j] = sc.next();
            }
            int[] w = new int[n];
            for(int j=0;j<n;j++) {
                w[j] = sc.nextInt();
                insert(root, dict[j], w[j]);
            }
            String[] pf = new String[m];
            for(int j=0;j<m;j++) {
                pf[j] = sc.next();
            }

            for(int j=0;j<m;j++) {
                List<String> res = findWordsWithPrefix(root, pf[j]);
                if(res.size() > 0) {
                    res = res.subList(0, Math.min(5, res.size()));
                    for(String s: res) {
                        System.out.print(s + " ");
                    }
                    System.out.println();
                } else {
                    System.out.println(-1);
                }
            }
        }
    }


}
