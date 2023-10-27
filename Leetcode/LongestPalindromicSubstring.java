// url: https://leetcode.com/problems/longest-palindromic-substring/

class Solution {

    int leftPtr, maxLen;

    private void longestPalFromCenter(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            if(r - l + 1 > maxLen) {
                leftPtr = l;
                maxLen = r - l + 1;
            }
            l--;
            r++;
        }
    }

    public String longestPalindrome(String s) {
        maxLen = 0;
        leftPtr = 0;
        for(int i = 0; i < s.length(); i++) {
            longestPalFromCenter(s, i, i);
            longestPalFromCenter(s, i, i+1);
        }
        return s.substring(leftPtr, leftPtr + maxLen);
    }
}
