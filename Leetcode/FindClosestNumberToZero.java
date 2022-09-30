// url: https://leetcode.com/problems/find-closest-number-to-zero/

class Solution {
    public int findClosestNumber(int[] nums) {
        int minDist = Math.abs(nums[0]), min = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(Math.abs(nums[i]) <= minDist) {
                if(minDist == Math.abs(nums[i])) 
                    min = Math.max(min, nums[i]);
                else {
                    minDist = Math.abs(nums[i]);
                    min = nums[i];
                }
            }
        }
        return min;
    }
}
