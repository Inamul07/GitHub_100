// url: https://leetcode.com/problems/subsets-ii/

class Solution {

    Set<List<Integer>> res;

    private void dfs(int i, int[] nums, List<Integer> subset) {
        if(i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(i+1, nums ,subset);
        subset.remove(subset.size()-1);
        dfs(i+1, nums, subset);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new HashSet<>();
        dfs(0, nums, new ArrayList<>());
        return new ArrayList<>(res);
    }
}
