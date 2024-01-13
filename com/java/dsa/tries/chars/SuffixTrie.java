package com.java.dsa.tries.chars;
public class SuffixTrie {
    private CharTrieNode root;
    SuffixTrie() {
        root = new CharTrieNode();
    }

    public void insert(String s) {
        CharTrieNode temp = root;
        for(int i = s.length() - 1; i >= 0; i--) {
            int key = s.charAt(i) - 'a';
            if(temp.nodes[key] == null)
                temp.nodes[key] = new CharTrieNode();
            temp = temp.nodes[key]; 
        }
        temp.end = true;
    }

    public boolean search(String s) {
        CharTrieNode temp = root;
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