// url: https://leetcode.com/problems/jump-game-ii/

class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int start = 0, end = 0, res = 0;
        while(end < nums.length-1) {
            int max = 0;
            for(int i = start; i <= end; i++) max = Math.max(max, i + nums[i]);
            start = end + 1;
            end = max;
            res++;
        }
        return res;
    }
}
