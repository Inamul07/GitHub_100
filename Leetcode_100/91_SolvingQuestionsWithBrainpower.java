// url: https://leetcode.com/problems/solving-questions-with-brainpower/

class Solution {

    int[][] questions;
    Map<Integer, Long> map;

    private long dfs(int idx) {
        if(idx >= questions.length) return 0l;
        if(map.containsKey(idx)) return map.get(idx);
        long l = dfs(idx+1), r = questions[idx][0] + dfs(idx + 1 + questions[idx][1]);
        map.put(idx, Math.max(l, r));
        return Math.max(l, r);
    }

    public long mostPoints(int[][] questions) {
        this.questions = questions;
        this.map = new HashMap<>();
        return dfs(0);
    }
}
