// url: https://leetcode.com/problems/implement-trie-prefix-tree/

class TrieNode {

    Map<Character, TrieNode> child;
    boolean endOfWord;

    TrieNode() {
        child = new HashMap<>();
        endOfWord = false;
    }
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char ch: word.toCharArray()) {
            if(!curr.child.containsKey(ch)) curr.child.put(ch, new TrieNode());
            curr = curr.child.get(ch);
        }
        curr.endOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(char ch: word.toCharArray()) {
            if(!curr.child.containsKey(ch)) return false;
            curr = curr.child.get(ch);
        }
        return curr.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char ch: prefix.toCharArray()) {
            if(!curr.child.containsKey(ch)) return false;
            curr = curr.child.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
