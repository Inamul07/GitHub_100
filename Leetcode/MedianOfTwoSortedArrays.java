// url: https://leetcode.com/problems/median-of-two-sorted-arrays/

// Brute Force - (Not Accepted)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int p1 = 0, p2 = 0, idx = 0;
        while(p1 < nums1.length && p2 < nums2.length) {
            if(nums1[p1] < nums2[p2]) nums[idx++] = nums1[p1++];
            else nums[idx++] = nums2[p2++];
        }
        while(p1 < nums1.length) nums[idx++] = nums1[p1++];
        while(p2 < nums2.length) nums[idx++] = nums2[p2++];
        if(nums.length%2 != 0) return (double) nums[nums.length/2];
        return (nums[nums.length/2] + nums[(nums.length/2) - 1]) / 2.0;
    }
}
