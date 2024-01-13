package com.java.dsa.tries.chars;
public class SuffixTrie {
    private TrieNode root;
    SuffixTrie() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode temp = root;
        for(int i = s.length() - 1; i >= 0; i--) {
            int key = s.charAt(i) - 'a';
            if(temp.nodes[key] == null)
                temp.nodes[key] = new TrieNode();
            temp = temp.nodes[key]; 
        }
        temp.end = true;
    }

    public boolean search(String s) {
        TrieNode temp = root;
        if(root == null)
            return false;
        for(int i = s.length() - 1; i >= 0; i--) {
            int key = s.charAt(i) - 'a';
            if(temp.nodes[key] == null)
                return false;
            temp = temp.nodes[key];
            if(temp.end)
                return true;
        }
        return false;
    }
}