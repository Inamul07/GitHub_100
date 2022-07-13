// url: https://leetcode.com/problems/product-of-array-except-self/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pro = 1, flag = 0;
        for(int i: nums) {
            if(i == 0) flag++;
            else pro *= i;
        }
        if(flag > 1) return new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(flag == 1 && nums[i] != 0) nums[i] = 0;
            else if(nums[i] != 0) nums[i] = (pro / nums[i]);
            else nums[i] = pro;
        }
        return nums;
    }
}