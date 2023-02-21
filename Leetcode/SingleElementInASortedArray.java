// url: https://leetcode.com/problems/single-element-in-a-sorted-array/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        int l = 0, r = nums.length-1, mid = 0;
        while(l <= r) {
            mid = l + (r - l) / 2;
            if((mid-1 < 0 || nums[mid] != nums[mid-1]) && (mid+1 >= nums.length || nums[mid] != nums[mid+1])) 
                return nums[mid];
            int lSize = mid;
            if(nums[mid] == nums[mid-1]) lSize = mid-1;
            if(lSize%2 == 0) l = mid+1;
            else r = mid-1;
        }
        return -1;
    }
}
