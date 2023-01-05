// url: https://leetcode.com/problems/ransom-note

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alpha = new int[26];
        for(char ch: ransomNote.toCharArray()) alpha[ch - 'a']++;
        for(char ch: magazine.toCharArray()) {
            if(alpha[ch - 'a'] > 0) alpha[ch - 'a']--;
        }
        for(int i = 0; i < 26; i++)
            if(alpha[i] != 0) return false;
        return true;
    }
}
