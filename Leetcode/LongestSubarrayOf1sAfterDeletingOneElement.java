// url: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0, maxLen = 0, numZeroes = 0, end;
        for(end = 0; end < nums.length; end++) {
            if(nums[end] == 0) numZeroes++;
            if(numZeroes > 1) {
                maxLen = Math.max(maxLen, end-start-1);
                while(nums[start] != 0) start++;
                start++;
                numZeroes = 1;
            }
        }
        end--;
        if(numZeroes <= 1) maxLen = Math.max(maxLen, end-start);
        return maxLen;
    }
}
