// url: https://leetcode.com/problems/longest-palindromic-substring/

class Solution {

    String res;
    int maxLen;

    private void longestPalFromCenter(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            if(r - l + 1 > maxLen) {
                res = s.substring(l, r+1);
                maxLen = r - l + 1;
            }
            l --;
            r++;
        }
    }

    public String longestPalindrome(String s) {
        res = "";
        maxLen = 0;
        for(int i = 0; i < s.length(); i++) {
            longestPalFromCenter(s, i, i);
            longestPalFromCenter(s, i, i+1);
        }
        return res;
    }
}
