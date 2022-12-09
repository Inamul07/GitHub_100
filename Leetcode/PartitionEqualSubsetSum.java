// url: https://leetcode.com/problems/partition-equal-subset-sum/

class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;
        for(int i: nums) target += i;
        if(target%2 != 0) return false;
        target /= 2;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for(int i = nums.length-1; i >= 0; i--) {
            Set<Integer> tempSet = new HashSet<>(set);
            for(int j: set) tempSet.add(nums[i] + j);
            set = tempSet;
            if(set.contains(target)) return true;
        }
        return false;
    }
}
