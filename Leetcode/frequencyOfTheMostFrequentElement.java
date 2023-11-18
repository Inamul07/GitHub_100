class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0, start = 0;
        long sum = 0;
        for(int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while(nums[end] * (end - start + 1) > sum + k) {
                sum -= nums[start];
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}
