// url: https://leetcode.com/problems/maximum-ascending-subarray-sum/

class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = 0, prev = 0, sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(prev >= nums[i]) sum = 0;
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            prev = nums[i];
        }
        return maxSum;
    }
}
