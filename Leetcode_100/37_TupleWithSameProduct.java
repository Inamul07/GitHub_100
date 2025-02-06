// url: https://leetcode.com/problems/tuple-with-same-product/
// Refreshed streak 5

class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                int pro = nums[i] * nums[j];
                map.putIfAbsent(pro, 0);
                map.put(pro, map.get(pro) + 1);
            }
        }
        for(int i: map.keySet()) res += (map.get(i) * (map.get(i)-1)) * 4;
        return res;
    }
}
