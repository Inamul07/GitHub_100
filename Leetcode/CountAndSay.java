// url: https://leetcode.com/problems/count-and-say/

class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String s = countAndSay(n-1), res = "";
        int count = 1;
        char prev = s.charAt(0);
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != prev) {
                res += count + "" + prev;
                count = 1;
                prev = s.charAt(i);
            } else count++;
        }
        if(count != 0) res += count + "" + prev;
        return res;
    }
}
