// url: https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/

class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int preSum = 0, sufSum = 0;
        for(int i: nums) sufSum += i;
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            sufSum -= nums[i];
            res[i] = (nums[i] * i - preSum) + Math.abs(nums[i] * (nums.length - i - 1) - sufSum);
            preSum += nums[i];
        }
        return res;
    }
}
