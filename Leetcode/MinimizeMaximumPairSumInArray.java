// url: https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxPair = 0, start = 0, end = nums.length-1;
        while(start < end) {
            maxPair = Math.max(maxPair, nums[start] + nums[end]);
            start++;
            end--;
        }
        return maxPair;
    }
}
