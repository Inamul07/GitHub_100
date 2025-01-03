// url: https://leetcode.com/problems/number-of-ways-to-split-array/?envType=daily-question&envId=2025-01-03
class Solution {
    public int waysToSplitArray(int[] nums) {
        long lSum = 0, rSum = 0;
        int res = 0;
        for(int i = nums.length-1; i >= 0; i--) rSum += nums[i];
        for(int i = 0; i < nums.length-1; i++) {
            lSum += nums[i];
            rSum -= nums[i];
            if(lSum >= rSum) res++;
        }
        return res;
    }
}
