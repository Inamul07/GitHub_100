// url: https://leetcode.com/problems/contiguous-array/

class Solution {
    public int findMaxLength(int[] nums) {
        if(nums.length == 2 && nums[0] != nums[1]) return 2;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sumOfOnes = 0, maxLen = 0;
        for(int i = 0; i < nums.length; i++) {
            sumOfOnes += nums[i];
            int diff = 2 * sumOfOnes - i;
            if(map.containsKey(diff)) 
                maxLen = Math.max(maxLen, i - map.get(diff));
            else 
                map.put(diff, i);
        }
        return maxLen;
    }
}
