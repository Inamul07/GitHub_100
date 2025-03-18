// url: https://leetcode.com/problems/longest-nice-subarray/

class Solution {
    public int longestNiceSubarray(int[] nums) {
        int num = 0, start = 0, maxLen = 0;
        for(int end = 0; end < nums.length; end++) {
            while((nums[end] & num) != 0) {
                num ^= nums[start];
                start++;
            }
            num |= nums[end];
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
