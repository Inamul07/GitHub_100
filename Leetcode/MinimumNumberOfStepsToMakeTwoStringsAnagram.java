// url: https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/

class Solution {
    public int minSteps(String s, String t) {
        int[] alpha1 = new int[26], alpha2 = new int[26];
        for(char ch: s.toCharArray()) alpha1[ch-'a']++;
        for(char ch: t.toCharArray()) alpha2[ch-'a']++;
        int res = 0;
        for(int i = 0; i < 26; i++) res += Math.abs(alpha1[i] - alpha2[i]);
        return res / 2;
    }
}
