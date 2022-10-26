// url: https://leetcode.com/problems/continuous-subarray-sum/

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            int rem = totalSum%k;
            if(map.containsKey(rem)) {
                if(i-map.get(rem) > 1) return true;
                continue;
            }
            map.put(rem, i);
        }
        return false;
    }
}
