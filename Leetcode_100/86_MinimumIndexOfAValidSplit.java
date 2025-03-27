// url: https://leetcode.com/problems/minimum-index-of-a-valid-split/

class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0, domNum = 0;
        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if(map.get(i) > maxFreq) {
                domNum = i;
                maxFreq = map.get(i);
            }
        }
        int count = 0;
        for(int i = 0; i < nums.size(); i++) {
            if(nums.get(i) == domNum) count++;
            if(count > (i + 1) / 2 && (maxFreq - count) > (nums.size() - i - 1) / 2) return i;
        }
        return -1;
    }
}
