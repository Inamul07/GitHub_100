// url: https://leetcode.com/problems/repeated-substring-pattern/

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for(int i = 1; i <= s.length()/2; i++) {
            if(s.length() % i == 0) {
                String str = s.substring(0, i);
                str = str.repeat(s.length() / i);
                if(str.equals(s)) return true;
            }
        }
        return false;
    }
}
