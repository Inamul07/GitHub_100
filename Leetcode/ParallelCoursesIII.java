// url: https://leetcode.com/problems/parallel-courses-iii/

class Solution {

    Map<Integer, List<Integer>> map;
    int res;
    int[] dp;

    private int dfs(int node, int[] time) {
        if(dp[node] != 0) return dp[node];
        int t = 0;
        for(int child: map.get(node)) t = Math.max(t, dfs(child, time));
        dp[node] = time[node] + t;
        return dp[node];
    }

    public int minimumTime(int n, int[][] relations, int[] time) {
        map = new HashMap<>();
        dp = new int[n];
        res = 0;
        for(int i = 0; i < n; i++) map.putIfAbsent(i, new ArrayList<>());
        for(int[] relation: relations) map.get(relation[0]-1).add(relation[1]-1);
        System.out.println(map);
        for(int i = 0; i < n; i++) {
            int val = dfs(i, time);
            res = Math.max(res, val);
        }
        return res;
    }
}
