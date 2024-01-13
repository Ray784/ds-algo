package com.java.dsa.tries.bit;

import java.util.Arrays;
public class BitTrieNode {
    BitTrieNode[] nodes;
    BitTrieNode() {
        nodes = new BitTrieNode[2]; // 2 children since bits can be only either0 or 1
    }
    public String toString() {
        return Arrays.toString(nodes);
    }
}