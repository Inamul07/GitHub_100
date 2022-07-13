// url: https://leetcode.com/problems/valid-anagram/

class Solution {
    
    public Map freq(String s) {
        Map<Character, Integer> map = new TreeMap<>();
        for(char ch: s.toCharArray()) {
            if(map.containsKey(ch)) map.put(ch, map.get(ch)+1);
            else map.put(ch, 1);
        }
        return map;
    }
    
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> m1 = new TreeMap<>(), m2 = new TreeMap<>();
        m1 = freq(s);
        m2 = freq(t);
        return m1.toString().equals(m2.toString());
        // for(char ch: m1.keySet()) {
        //     if(m2.containsKey(ch) && m1.get(ch) == m2.get(ch)) continue;
        //     return false;
        // }
        // return true;
    }
}

// Solution 2:

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alpha = new int[26];
        for(char ch: s.toCharArray()) alpha[ch - 'a']++;
        for(char ch: t.toCharArray()) alpha[ch - 'a']--;
        
        for(int i = 0; i < 26; i++) {
            if(alpha[i] != 0) return false;
        }
        return true;        
    }
}