// url: https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/

class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0, start = 0, res = -1;
        for(int i: nums) sum += i;
        int target = sum - x, tmpSum = 0;
        for(int end = 0; end < nums.length; end++) {
            tmpSum += nums[end];
            while(start <= end && tmpSum > target) {
                tmpSum -= nums[start];
                start++;
            }
            if(tmpSum == target) res = Math.max(res, end - start + 1);
        }
        return res == -1? -1: nums.length - res;
    }
}
