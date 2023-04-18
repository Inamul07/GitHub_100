// url: https://leetcode.com/problems/merge-strings-alternately/

class Solution {
    public String mergeAlternately(String word1, String word2) {
        String res = "";
        int p1 = 0, p2 = 0;
        while(p1 < word1.length() && p2 < word2.length()) {
            res += word1.charAt(p1++);
            res += word2.charAt(p2++);
        }
        while(p1 < word1.length()) res += word1.charAt(p1++);
        while(p2 < word2.length()) res += word2.charAt(p2++);
        return res;
    }
}
