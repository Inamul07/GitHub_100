// url: https://leetcode.com/problems/number-of-zero-filled-subarrays/

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0, consec = 0;
        for(int i: nums) {
            if(i == 0) {
                consec++;
                res += consec;
            } else consec = 0;
        }
        return res;
    }
}
