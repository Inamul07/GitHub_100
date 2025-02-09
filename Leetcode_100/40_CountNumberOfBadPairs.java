// url: https://leetcode.com/problems/count-number-of-bad-pairs/

class Solution {
    public long countBadPairs(int[] nums) {
        long lIdx = (long) nums.length-1;
        long totalPairs = (lIdx) * (lIdx + 1) / 2, goodPairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int slope = nums[i] - i;
            map.putIfAbsent(slope, 0);
            goodPairs += map.get(slope);
            map.put(slope, map.get(slope) + 1);
        }
        return totalPairs - goodPairs;
    }
}
