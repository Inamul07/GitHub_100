// url: https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < groupSizes.length; i++) {
            map.putIfAbsent(groupSizes[i], new ArrayList<>());
            map.get(groupSizes[i]).add(i);
            if(map.get(groupSizes[i]).size() == groupSizes[i]) {
                res.add(new ArrayList<>(map.get(groupSizes[i])));
                map.get(groupSizes[i]).clear();
            }
        }
        return res;
    }
}
