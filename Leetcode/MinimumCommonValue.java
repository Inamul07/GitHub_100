// url: https://leetcode.com/problems/minimum-common-value/

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int p1 = 0, p2 = 0;
        while(p1 < nums1.length && p2 < nums2.length) {
            while(p1 < nums1.length && nums1[p1] < nums2[p2]) p1++;
            while(p1 < nums1.length && p2 < nums2.length && nums2[p2] < nums1[p1]) p2++;
            if(p1 >= nums1.length || p2 >= nums2.length) break;
            if(nums1[p1] == nums2[p2]) return nums1[p1];
        }
        return -1;
    }
}
