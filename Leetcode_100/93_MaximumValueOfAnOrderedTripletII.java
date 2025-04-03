// url: https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/

class Solution {
    public long maximumTripletValue(int[] nums) {
        int maxNum = nums[0];
        long maxDiff = 0, res = 0;
        for(int i = 1; i < nums.length; i++) {
            res = Math.max(res, maxDiff * nums[i]);
            maxNum = Math.max(maxNum, nums[i]);
            maxDiff = Math.max(maxDiff, maxNum - nums[i]);
        }
        return res;
    }
}
