// url: https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/

class Solution {
    public int findSpecialInteger(int[] arr) {
        int minResLen = (int) ((25.0 / 100) * arr.length) + 1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if(map.get(i) >= minResLen) return i;
        }
        return -1;
    }
}
