// url: https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/

class Solution {
    
    Map<Integer, Boolean> map;

    private boolean dfs(int i, int[] nums) {
        if(i == nums.length) return true;
        if(i > nums.length) return false;
        if(map.containsKey(i)) return map.get(i);
        boolean lSubTree = false, rSubTree = false;
        if(i < nums.length-1 && nums[i] == nums[i+1]) {
            boolean res = dfs(i+2, nums);
            map.put(i+2, res);
            if(res) return true;
        } 
        if((i < nums.length-2 && nums[i] == nums[i+1] && nums[i+1] == nums[i+2])
            || (i < nums.length-2 && nums[i]+1 == nums[i+1] && nums[i+1]+1 == nums[i+2])) {
                boolean res = dfs(i+3, nums);
                map.put(i+3, res);
                if(res) return true;
            }
        return false;
    }

    public boolean validPartition(int[] nums) {
        map = new HashMap<>();
        return dfs(0, nums);
    }
}
