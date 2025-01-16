// url: https://leetcode.com/problems/bitwise-xor-of-all-pairings/
class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor = 0;
        if(nums1.length % 2 != 0) {
            for(int i: nums2) xor ^= i;
        }
        if(nums2.length % 2 != 0) {
            for(int i: nums1) xor ^= i;
        }
        return xor;
    }
}
