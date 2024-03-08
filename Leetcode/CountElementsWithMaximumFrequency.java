// url: https://leetcode.com/problems/count-elements-with-maximum-frequency/

class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums) map.put(i, map.getOrDefault(i, 0) + 1);
        int maxFreq = 0, res = 0;
        for(int i: map.keySet()) if(map.get(i) > maxFreq) maxFreq = map.get(i);
        for(int i: map.keySet()) if(map.get(i) == maxFreq) res += maxFreq;
        return res; 
    }
}
