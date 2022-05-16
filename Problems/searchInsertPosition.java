// url: https://leetcode.com/problems/search-insert-position/submissions/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length - 1;
        if(target < nums[0])
            return 0;
        else if(target > nums[len])
            return len + 1;
        else {
            int l = 0, r = nums.length - 1, mid = 0;
            while(l < r) {
                mid = l + (r - l) / 2;
                if(nums[mid] == target)
                    return mid;
                else if(nums[mid] > target)
                    r = mid;
                else
                    l = mid + 1;
            }
            if(target > nums[mid])
                return mid + 1;
            return mid;
        }
    }
}
