// url: https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/

class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums) {
            if(i < k) return -1;
            if(i > k) set.add(i);
        }
        return set.size();
    }
}
