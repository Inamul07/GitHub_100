// url: https://leetcode.com/problems/design-add-and-search-words-data-structure/

class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;

    TrieNode() {
        children = new HashMap<>();
        endOfWord = false;
    }
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char ch: word.toCharArray()) {
            if(!curr.children.containsKey(ch)) curr.children.put(ch, new TrieNode());
            curr = curr.children.get(ch);
        }
        curr.endOfWord = true;
    }
    
    public boolean search(String word) {
        return searchWord(root, word, 0);
    }

    public boolean searchWord(TrieNode node, String word, int index) {
        if(word.length() == index) return node.endOfWord;
        char ch = word.charAt(index);
        if(!node.children.containsKey(ch)) {
            if(ch != '.') return false;
            for(char c: node.children.keySet()) {
                if(searchWord(node.children.get(c), word, index+1)) return true;
            }
            return false;
        } 
        return searchWord(node.children.get(ch), word, index+1);
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
