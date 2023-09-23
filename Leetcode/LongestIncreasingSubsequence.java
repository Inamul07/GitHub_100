// url: https://leetcode.com/problems/longest-increasing-subsequence/

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);
        int res = 0;
        for(int i = nums.length-1; i >= 0; i--) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] < nums[j]) lis[i] = Math.max(lis[i], 1 + lis[j]);
            }
            res = Math.max(res, lis[i]);
        }
        return res;
    }
}
