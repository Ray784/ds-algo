import java.util.*;

class BitTrieNode {
    BitTrieNode nodes[];
    BitTrieNode() {
        nodes = new BitTrieNode[2];
    }
    public String toString() {
        return Arrays.toString(nodes);
    }
}

public class BitTrie {
    BitTrieNode root;
    private int power = 31; // 32 bit integer
    BitTrie() {
        root = new BitTrieNode();
    }
    
    public void insert(int val) {
        // System.out.println("insert: " + val);
        int mask = power, bit;
        BitTrieNode temp = root;
        while(mask >= 0) {
            bit = (val >> mask) & 1;
            if(temp.nodes[bit] == null)
                temp.nodes[bit] = new BitTrieNode();
            temp = temp.nodes[bit];
            mask--;
        }
    }
    
    public int getXorMax(int val) {
        // System.out.println("max: " + val);
        int mask = power, bit, opp;
        BitTrieNode temp = root;
        int res = 0;
        while(mask >= 0) {
            bit = (val >> mask) & 1;
            opp = bit ^ 1;
            res <<= 1;
            if(temp == null)
                return -1;
            else if(temp.nodes[opp] != null) {
                temp = temp.nodes[opp];
                res |= opp;
            }
            else {
                temp = temp.nodes[bit];
                res |= bit;
            }
            mask--;
        }
        return res;
    }
    
    public void remove(int val) {
        // System.out.println("remove: " + val);
        int mask = power, bit;
        BitTrieNode temp = root;
        BitTrieNode rem = root;
        int cb = 0;
        while(mask >= 0) {
            bit = (val >> mask) & 1;
            if(temp.nodes[bit] == null)
                return;
            if(temp.nodes[0] != null && temp.nodes[1] != null){
                rem = temp;
                cb = bit;
            }
            temp = temp.nodes[bit];
            mask--;
        }
        if(cb != -1)
            rem.nodes[cb] = null;
    }
    
    public String toString() {
        return root.toString();
    }
}