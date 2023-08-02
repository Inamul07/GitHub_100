// url: https://leetcode.com/problems/permutations/

class Solution {

    List<List<Integer>> res;

    private void backtrack(int[] nums, List<Integer> subset) {
        if(subset.size() == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        for(int i: nums) {
            if(!subset.contains(i)) {
                subset.add(i);
                backtrack(nums, subset);
                subset.remove(subset.size()-1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums, new ArrayList<>());
        return res;
    }
}
