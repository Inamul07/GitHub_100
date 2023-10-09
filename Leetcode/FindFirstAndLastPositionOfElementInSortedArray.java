// url: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        Arrays.fill(res, -1);
        int start = 0, end = nums.length-1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                int l = mid, r = mid;
                while(l >= 0 && nums[l] == target) l--;
                while(r < nums.length && nums[r] == target) r++;
                res[0] = l+1;
                res[1] = r-1;
                return res;
            } else if(nums[mid] < target) start = mid+1;
            else if(nums[mid] > target) end = mid-1;
        }
        return res;
    }
}
