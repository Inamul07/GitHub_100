// url: https://leetcode.com/problems/number-of-zero-filled-subarrays/

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0, consec = 0;
        boolean isZero = false;
        for(int i: nums) {
            if(i == 0) isZero = true;
            else isZero = false;
            if(i == 0 && isZero) {
                consec++;
                res += consec;
            } else consec = 0;
        }
        return res;
    }
}
