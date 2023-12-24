// url: https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/

class Solution {

    private int helper(char f, String s) {
        int res = 0;
        for(char ch: s.toCharArray()) {
            if(ch != f) res++;
            if(f == '0') f = '1';
            else f = '0';
        }
        return res;
    }

    public int minOperations(String s) {
        int m1 = helper('1', s), m2 = helper('0', s);
        return Math.min(m1, m2);
    }
}
