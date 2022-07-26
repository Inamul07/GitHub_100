// url: https://leetcode.com/problems/jump-game/

class Solution {
    public boolean canJump(int[] nums) {
        int idx = nums.length - 1;
        for(int i = idx-1; i >= 0; i--) {
            if(i + nums[i] >= idx)
                idx = i;
        }
        return idx == 0? true: false;
    }
}
