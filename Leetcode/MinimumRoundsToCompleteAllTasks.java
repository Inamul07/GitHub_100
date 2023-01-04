// url: https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks

class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: tasks) map.put(i, map.getOrDefault(i, 0) + 1);
        int res = 0;
        for(int i: map.keySet()) {
            if(map.get(i) == 1) return -1;
            else if(map.get(i) == 2 || map.get(i) == 3) res += 1;
            else res += (map.get(i) + 2) / 3;
        }
        return res;
    }
}
