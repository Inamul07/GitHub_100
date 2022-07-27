// url: https://leetcode.com/problems/valid-palindrome/

class Solution {
    public boolean isPalindrome(String s) {
        int flag = 0;
        for(char ch: s.toCharArray()) {
            if(Character.isLetterOrDigit(ch)) {
                flag = 1;
                break;
            }
        }
        if(flag == 0) return true;
        s = s.toLowerCase();
        int i = 0, j = s.length()-1;
        while(i <= j) {
            while(!Character.isLetterOrDigit(s.charAt(i))) i++;
            while(!Character.isLetterOrDigit(s.charAt(j))) j--;
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
