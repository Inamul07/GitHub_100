// url: https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

class Solution {
    public boolean check(int[] nums) {
        int idx = 1, prev = nums[0], min = nums[0];
        for(; idx < nums.length; idx++) {
            if(nums[idx] < prev) break;
            min = Math.min(min, nums[idx]);
            prev = nums[idx];
        }
        if(idx == nums.length) return true;
        prev = nums[idx];
        int max = nums[idx++];
        for(; idx < nums.length; idx++) {
            if(nums[idx] < prev) return false;
            max = Math.max(max, nums[idx]);
            prev = nums[idx];
        }
        return min >= max;
    }
}
