// url : https://leetcode.com/problems/palindrome-number/solution/

class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int len = s.length() - 1;
        String rev = "";
        for(int i = len; i >= 0; i--)
            rev += s.charAt(i);
        if(s.equals(rev))
            return true;
        return false;
    }
}
