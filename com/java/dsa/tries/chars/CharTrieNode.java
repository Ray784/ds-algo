package com.java.dsa.tries.chars;

public class CharTrieNode {
    CharTrieNode[] nodes;
    boolean end;
    CharTrieNode() {
        nodes = new CharTrieNode[26];
        end = false; // mark end of a word
    }
}