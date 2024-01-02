// url: https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums) map.put(i, map.getOrDefault(i, 0) + 1);
        for(int i: map.keySet()) {
            while(list.size() < map.get(i)) list.add(new ArrayList<>());
            for(int idx = 0; idx < map.get(i); idx++) list.get(idx).add(i);
        }
        return list;
    }
}
