package com.java.dsa.tries.chars;

public class TrieNode {
    TrieNode[] nodes;
    boolean end;
    TrieNode() {
        nodes = new TrieNode[26];
        end = false; // mark end of a word
    }
}