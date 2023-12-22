// url: https://leetcode.com/problems/maximum-score-after-splitting-a-string/

class Solution {
    public int maxScore(String s) {
        int r = 0, res = 0, l = 0;
        for(char ch: s.toCharArray()) if(ch == '1') r++;
        for(int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) == '1') r--;
            if(s.charAt(i) == '0') l++;
            res = Math.max(res, l+r);
        }
        return res;
    }
}
