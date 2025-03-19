// url: https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/

class Solution {
    public int minOperations(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0 && (i+3) > nums.length) return -1;
            if(nums[i] == 0) {
                for(int j = i; j < i+3; j++) nums[j] ^= 1;
                res++;
            }
        }
        return res;
    }
}
