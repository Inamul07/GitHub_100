// url: https://leetcode.com/problems/first-missing-positive/

class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++) if(nums[i] < 0) nums[i] = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) continue;
            int currNum = Math.abs(nums[i]);
            if(currNum - 1 < 0 || currNum - 1 >= nums.length) continue;
            if(nums[currNum - 1] > 0) nums[currNum - 1] = -1 * nums[currNum - 1];
            else if(nums[currNum - 1] == 0) nums[currNum - 1] = -1 * (nums.length + 1);
        }
        for(int i = 1; i <= nums.length; i++) {
            if(nums[i-1] >= 0) return i;
        }
        return nums.length+1;
    }
}
