// url: https://leetcode.com/problems/count-total-number-of-colored-cells/

class Solution {
    public long coloredCells(int n) {
        if(n == 1) return 1l;
        long oddNum = 1, res = 1;
        for(int i = 1; i < n; i++) {
            res += (oddNum * 2) + 2;
            oddNum += 2;
        }
        return res;
    }
}
