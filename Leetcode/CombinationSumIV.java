// url: https://leetcode.com/problems/combination-sum-iv/

class Solution {

    Map<Integer, Integer> map;

    private int backtrack(int sum, int target, int[] nums) {
        if(sum > target) return 0;
        if(sum == target) return 1;
        if(map.containsKey(sum)) return map.get(sum);
        int ways = 0;
        for(int i = 0; i < nums.length; i++) ways += backtrack(sum + nums[i], target, nums);
        map.put(sum, ways);
        return ways;
    }

    public int combinationSum4(int[] nums, int target) {
        map = new HashMap<>();
        return backtrack(0, target, nums);
    }
}
