// url: https://leetcode.com/problems/k-radius-subarray-averages/

class Solution {
    public int[] getAverages(int[] nums, int k) {
        int res[] = new int[nums.length], start = 0;
        Arrays.fill(res, -1);
        long sum = 0;
        for(int end = 0; end < nums.length; end++) {
            if(end < 2*k) sum += nums[end];
            else {
                sum += nums[end];
                res[end-k] = (int) (sum / (end-start+1));
                sum -= nums[start];
                start++;
            }
        }
        return res;
    }
}
