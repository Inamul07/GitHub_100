// url: https://leetcode.com/problems/special-array-i/

class Solution {
    public boolean isArraySpecial(int[] nums) {
        for(int i = 0; i < nums.length-1; i++) {
            int n1 = nums[i], n2 = nums[i+1];
            if(!((n1%2 == 0 && n2%2 != 0) || (n1%2 != 0 && n2%2 == 0))) return false;
        }
        return true;
    }
}
