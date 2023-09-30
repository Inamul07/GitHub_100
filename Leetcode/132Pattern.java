// url: https://leetcode.com/problems/132-pattern/

class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int min = nums[0];
        for(int i = 1; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[i] >= stack.peek()[0]) stack.pop();
            if(!stack.isEmpty() && nums[i] > stack.peek()[1]) return true;
            stack.push(new int[] {nums[i], min});
            min = Math.min(min, nums[i]);
        }
        return false;
    }
}
