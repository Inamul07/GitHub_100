// url: https://leetcode.com/problems/binary-subarrays-with-sum/

class Solution {

    private int numSubarraysLessThanSum(int[] nums, int goal) {
        int start = 0, currSum = 0, res = 0;
        for(int end = 0; end < nums.length; end++) {
            currSum += nums[end];
            while(currSum > goal && start <= end) {
                currSum -= nums[start];
                start++;
            }
            if(currSum <= goal) res += (end - start + 1);
        }
        return res;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int res1 = numSubarraysLessThanSum(nums, goal), res2 = numSubarraysLessThanSum(nums, goal-1);
        return res1 - res2;
    }
}
