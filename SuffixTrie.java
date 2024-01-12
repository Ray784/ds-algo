public class SuffixTrie {
    private SuffixTrieNode root;
    SuffixTrie() {
        root = new SuffixTrieNode();
    }

    public void insert(String s) {
        SuffixTrieNode temp = root;
        for(int i = s.length() - 1; i >= 0; i--) {
            int key = s.charAt(i) - 'a';
            if(temp.nodes[key] == null)
                temp.nodes[key] = new SuffixTrieNode();
            temp = temp.nodes[key]; 
        }
        temp.end = true;
    }

    public boolean search(String s) {
        SuffixTrieNode temp = root;
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

class SuffixTrieNode {
    SuffixTrieNode[] nodes;
    boolean end;
    SuffixTrieNode() {
        nodes = new SuffixTrieNode[26];
        end = false;
    }
}