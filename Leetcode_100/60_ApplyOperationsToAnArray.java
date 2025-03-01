// url: https://leetcode.com/problems/apply-operations-to-an-array/

class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }
        int[] res = new int[nums.length];
        int currIdx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) res[currIdx++] = nums[i];
        }
        return res;
    }
}
