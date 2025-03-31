// url: https://leetcode.com/problems/put-marbles-in-bags/

class Solution {
    public long putMarbles(int[] weights, int k) {
        if(weights.length <= k || k == 1) return 0;
        long[] nums = new long[weights.length-1];
        for(int i = 0; i < weights.length-1; i++) nums[i] = ((long) weights[i]) + weights[i+1];
        Arrays.sort(nums);
        long max = 0, min = 0;
        for(int i = nums.length-1; i > nums.length-k; i--) max += nums[i];
        for(int i = 0; i < k-1; i++) min += nums[i];
        return max - min;
    }
}
