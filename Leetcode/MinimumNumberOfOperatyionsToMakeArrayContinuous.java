// url: https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/

// Brute-Force (TLE)
class Solution {
    public int minOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums) set.add(i);
        int res = Integer.MAX_VALUE;
        for(int num: nums) {
            int val = 0;
            for(int i = num; i < num + nums.length; i++) if(!set.contains(i)) val++;
            res = Math.min(res, val);
        }
        return res;
    }
}
