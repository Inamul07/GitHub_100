// url: https://leetcode.com/problems/find-first-palindromic-string-in-the-array/

class Solution {

    private boolean isPallindrome(String s) {
        int start = 0, end = s.length()-1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public String firstPalindrome(String[] words) {
        for(String word: words) {
            if(isPallindrome(word)) return word;
        }
        return "";
    }
}
