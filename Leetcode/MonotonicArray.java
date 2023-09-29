// url: https://leetcode.com/problems/monotonic-array/

class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length == 1) return true;
        int flag = 0, l = 0, r = 1;
        if(nums[0] > nums[1]) flag = 1;
        while(flag == 0 && (nums[l] == nums[r])) {
            l++; r++;
            if(r == nums.length) return true;
            if(nums[l] > nums[r]) {
                flag = 1;
                break;
            }
        }
        for(int i = 1; i < nums.length; i++) {
            if((flag == 0 && !(nums[i] >= nums[i-1])) || (flag == 1 && !(nums[i] <= nums[i-1]))) return false;
        }
        return true;
    }
}
