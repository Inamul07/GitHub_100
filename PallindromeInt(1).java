// url: https://leetcode.com/problems/palindrome-number/submissions/

class Solution {
    public boolean isPalindrome(int x) {
        int rev = 0, temp = x;
        while(temp != 0) {
            int rem = temp % 10;
            rev = rev * 10 + rem;
            temp /= 10;
        }
        if(x == rev && x >= 0)
            return true;
        return false;
    }
}
