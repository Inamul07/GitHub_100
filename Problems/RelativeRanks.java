// url: https://leetcode.com/problems/relative-ranks/

class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] res = new String[score.length];
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int i = 0; i < score.length; i++) map.put(score[i], i);
        int pos = 1;
        for(int i: map.keySet()) {
            if(pos == 1) res[map.get(i)] = "Gold Medal";
            else if(pos == 2) res[map.get(i)] = "Silver Medal";
            else if(pos == 3) res[map.get(i)] = "Bronze Medal";
            else res[map.get(i)] = (pos+"");
            pos++;
        }
        return res;
    }
}
