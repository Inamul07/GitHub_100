// url: https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/

class Solution {
    public int maximumCount(int[] nums) {
        if(nums[0] > 0 || nums[nums.length-1] < 0) return nums.length;
        int neg = 0, pos = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) neg++;
            else if(nums[i] > 0) {
                pos = (nums.length - i);
                break;
            }
        }
        return Math.max(neg, pos);
    }
}
