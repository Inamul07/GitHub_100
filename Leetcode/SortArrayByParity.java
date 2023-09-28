// url: https://leetcode.com/problems/sort-array-by-parity/

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int l = 0;
        for(int r = 0; r < nums.length; r++) {
          if(nums[r] % 2 == 0) {
              int tmp = nums[l];
              nums[l] = nums[r];
              nums[r] = tmp;
              l++;

          }
        }
        return nums;
    }
}
