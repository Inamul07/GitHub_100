// url: https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/

class Solution {
    public boolean makeEqual(String[] words) {
        int[] alpha = new int[26];
        for(String word: words) {
            for(char ch: word.toCharArray()) alpha[ch-'a']++;
        }
        for(int i: alpha) if(i % words.length != 0) return false;
        return true;
    }
}
