// url: https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0, maxLen = 0;
        for(int end = 0; end < nums.length; end++) {
            map.putIfAbsent(nums[end], 0);
            while(map.get(nums[end]) == k) {
                map.put(nums[start], map.get(nums[start])-1);
                start++;
            }
            map.put(nums[end], map.get(nums[end])+1);
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
