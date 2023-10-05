// url: https://leetcode.com/problems/majority-element-ii/

// Brute-Force
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums) map.put(i, map.getOrDefault(i, 0) + 1);
        for(int i: map.keySet()) if(map.get(i) > (nums.length/3)) res.add(i);
        return res;
    }
}
