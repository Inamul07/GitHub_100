// url: https://leetcode.com/problems/increasing-triplet-subsequence/

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int l = Integer.MAX_VALUE, m = Integer.MAX_VALUE;
        for(int i: nums) {
            if(i > l && i > m) return true;
            if(i <= l) l = i;
            else m = i;
        }
        return false;
    }
}
