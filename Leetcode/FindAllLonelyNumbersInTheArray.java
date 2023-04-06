// url: https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/

class Solution {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i: nums) map.put(i, map.getOrDefault(i, 0) + 1);
        for(int i: nums) {
            if(map.get(i) == 1 && !map.containsKey(i-1) && !map.containsKey(i+1))
                res.add(i);
        }
        return res;
    }
}
