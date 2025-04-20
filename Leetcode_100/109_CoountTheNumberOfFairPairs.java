// url: https://leetcode.com/problems/count-the-number-of-fair-pairs/

class Solution {

    private int binarySearch(int[] nums, int l, int r, int target) {
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] >= target) r = mid-1;
            else l = mid+1;
        }
        return r;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        long res = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int low = lower - nums[i];
            int high = upper - nums[i];
            res += (binarySearch(nums, i+1, nums.length-1, high + 1) - binarySearch(nums, i+1, nums.length-1, low));
        }
        return res;
    }
}
