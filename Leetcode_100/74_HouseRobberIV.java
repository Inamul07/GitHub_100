// url: https://leetcode.com/problems/house-robber-iv/

class Solution {
    public int minCapability(int[] nums, int k) {
        int l = Integer.MAX_VALUE, r = 0, res = 0;
        for(int i: nums) {
            l = Math.min(l, i);
            r = Math.max(r, i);
        }
        while(l <= r) {
            int mid =  l + (r - l) / 2;
            int count = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] <= mid) {
                    count++;
                    i++;
                    if(count == k) break;
                }
            }
            if(count == k) {
                res = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return res;
    }
}
