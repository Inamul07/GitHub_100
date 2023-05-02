// url: https://leetcode.com/problems/sign-of-the-product-of-an-array/

class Solution {
    public int arraySign(int[] nums) {
        int res = 1;
        for(int i: nums) {
            if(i == 0) return 0;
            if(i < 0) res = -res;
        }
        return res;
    }
}
