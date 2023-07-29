// url: https://leetcode.com/problems/subsets/

class Solution {

    List<List<Integer>> res;

    private void dfs(int i, int[] nums, List<Integer> subset) {
        if(i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(i+1, nums, subset);
        subset.remove(subset.size()-1);
        dfs(i+1, nums, subset);
    }

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        dfs(0, nums, new ArrayList<>());
        return res;
    }
}
