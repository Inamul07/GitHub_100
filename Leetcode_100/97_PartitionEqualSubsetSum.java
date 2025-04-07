// url: https://leetcode.com/problems/partition-equal-subset-sum/

class Solution {

    Map<String, Boolean> map;

    private boolean dfs(int idx, int currSum, int targetSum, int[] nums) {
        if(currSum == targetSum) return true;
        if(currSum > targetSum || idx == nums.length) return false;
        String key = idx + "," + currSum;
        if(map.containsKey(key)) return map.get(key);
        boolean res = dfs(idx+1, currSum + nums[idx], targetSum, nums) || dfs(idx+1, currSum, targetSum, nums);
        map.put(key, res);
        return res;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums) sum += i;
        if(sum%2 != 0) return false;
        map = new HashMap<>();
        return dfs(0, 0, sum / 2, nums);
    }
}
