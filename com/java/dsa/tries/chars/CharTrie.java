package com.java.dsa.tries.chars;

public class CharTrie {
    private TrieNode root;
    CharTrie() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode temp = root;
        for(int i = 0; i < s.length(); i++) {
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
        for(int i = 0; i < s.length(); i++) {
            int key = s.charAt(i) - 'a';
            if(temp.nodes[key] == null)
                return false;
            temp = temp.nodes[key];
        }
        return temp.end;
    }
}