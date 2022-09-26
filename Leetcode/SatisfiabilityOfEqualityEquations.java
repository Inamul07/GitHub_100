// url: https://leetcode.com/problems/satisfiability-of-equality-equations/

class Solution {
    
    int[] parent = new int[26];
    
    public int find(int x) {
        if(x == parent[x]) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public boolean equationsPossible(String[] equations) {
        for(int i = 0; i < 26; i++) parent[i] = i;
        for(String s: equations) {
            char ch1 = s.charAt(0), ch2 = s.charAt(3);
            if(s.charAt(1) == '=') {
                parent[find(ch1-'a')] = find(parent[ch2-'a']);
            }
        }
        for(String s: equations) {
            char ch1 = s.charAt(0), ch2 = s.charAt(3);
            if(s.charAt(1) == '!') {
                if(find(parent[ch1-'a']) == find(parent[ch2-'a'])) return false;
            }
        }
        return true;
    }
}
