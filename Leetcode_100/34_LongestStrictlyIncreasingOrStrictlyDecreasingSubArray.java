// url: https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int currAscLen = 0, maxAscLen = 0, currDescLen = 0, maxDescLen = 0, prev = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > prev) currAscLen++;
            else currAscLen = 1;
            maxAscLen = Math.max(maxAscLen, currAscLen);
            if(nums[i] < prev) currDescLen++;
            else currDescLen = 1;
            maxDescLen = Math.max(maxDescLen, currDescLen);
            prev = nums[i];
        }
        return Math.max(maxAscLen, maxDescLen);
    }
}
