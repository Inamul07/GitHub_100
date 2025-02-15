// url: https://leetcode.com/problems/find-the-punishment-number-of-an-integer/

class Solution {

    private boolean isValidOp(String s, int i, int num, int sum) {
        if(i == s.length() && num == sum) return true;
        if(i == s.length()) return false;
        for(int idx = i; idx < s.length(); idx++) {
            int thisSum = Integer.parseInt(s.substring(i, idx+1));
            if(isValidOp(s, idx+1, num, sum + thisSum)) return true;
        }
        return false;
    }

    public int punishmentNumber(int n) {
        int res = 0;
        for(int i = 1; i <= n; i++) if(isValidOp((i*i) + "", 0, i, 0)) res += (i * i);
        return res;
    }
}
