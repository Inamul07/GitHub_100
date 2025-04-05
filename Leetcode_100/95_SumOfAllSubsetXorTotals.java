// url: https://leetcode.com/problems/sum-of-all-subset-xor-totals/

class Solution {

    int res;

    private void dfs(int i, int xor, int[] nums) {
        if(i == nums.length) {
            res += xor;
            return;
        }
        dfs(i+1, xor ^ nums[i], nums);
        dfs(i+1, xor, nums);
    }

    public int subsetXORSum(int[] nums) {
        res = 0;
        dfs(0, 0, nums);
        return res;
    }
}
