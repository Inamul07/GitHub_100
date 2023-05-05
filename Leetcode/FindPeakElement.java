// url: https://leetcode.com/problems/find-peak-element/

// Brute-Force O(n)
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1 || nums[0] > nums[1]) return 0;
        if(nums[nums.length-1] > nums[nums.length-2]) return nums.length-1;
        for(int i = 1; i < nums.length-1; i++) {
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]) return i;
        }
        return -1;
    }
}

// Optimized O(log n)
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1 || nums[0] > nums[1]) return 0;
        if(nums[nums.length-1] > nums[nums.length-2]) return nums.length-1;
        int start = 0, end = nums.length-1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(mid != 0 && mid != nums.length-1 && nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            if(nums[mid] < nums[mid+1]) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }
}
