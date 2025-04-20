// url: https://leetcode.com/problems/rabbits-in-forest/

class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i: answers) map.put(i, map.getOrDefault(i, 0) + 1);
        for(int i: map.keySet()) {
            int val = map.get(i);
            int num = val / (i+1);
            int rem = val % (i+1);
            res += (num * (i+1));
            if(rem != 0) res += (i+1);
        }
        return res;
    }
}
