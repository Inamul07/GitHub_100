// url: https://leetcode.com/problems/can-place-flowers/

class Solution {
    public boolean canPlaceFlowers(int[] nums, int n) {
        if(n == 0) return true;
        if(nums.length == 1 && nums[0] == 0) return --n == 0;
        if(nums[0] == 0 && nums[1] == 0) {
            nums[0] = 1;
            n--;
        } 
        for(int i = 1; i < nums.length-1; i++) {
            if(n != 0 && nums[i] == 0 && nums[i-1] == 0 && nums[i+1] == 0) {
                nums[i] = 1;
                if(--n == 0) break;
            }
        }
        if(n != 0 && nums[nums.length-1] == 0 && nums[nums.length-2] == 0) {
            nums[nums.length-1] = 1;
            n--;
        }
        return n == 0;
    }
}
