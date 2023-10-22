// url: https://leetcode.com/problems/maximum-score-of-a-good-subarray/

class Solution {
    public int maximumScore(int[] nums, int k) {
        int l = k, r = k, res = nums[k], min = nums[k];
        while(l > 0 || r < nums.length-1) {
            int lval = l > 0? nums[l-1]: 0, rval = r < nums.length-1? nums[r+1]: 0;
            if(lval > rval) {
                l--;
                min = Math.min(min, nums[l]);
            } else {
                r++;
                min = Math.min(min, nums[r]);
            }
            res = Math.max(res, min * (r - l + 1));
        }
        return res;
    }
}
