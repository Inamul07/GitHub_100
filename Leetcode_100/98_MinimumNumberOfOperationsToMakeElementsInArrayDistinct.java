// url: https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/

class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int i = nums.length-1; i >= 0; i--) {
            if(set.contains(nums[i])) {
                res = (i / 3) + 1;
                break;
            }
            set.add(nums[i]);
        }
        return res;
    }
}
