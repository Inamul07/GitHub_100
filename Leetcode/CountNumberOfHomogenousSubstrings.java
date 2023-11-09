// url: https://leetcode.com/problems/count-number-of-homogenous-substrings/

class Solution {
    public int countHomogenous(String s) {
        long res = 0;
        int mod = 1000000007, start = 0, end;
        for(end = 0; end < s.length(); end++) {
            if(s.charAt(start) != s.charAt(end)) {
                long winLen = end-start;
                res += (((winLen * (winLen + 1)) / 2) % mod);
            }
            while(s.charAt(start) != s.charAt(end)) start++;
        }
        long winLen = end-start;
        res += ((winLen * (winLen + 1)) / 2) % mod;
        return (int) res % mod;
    }
}
