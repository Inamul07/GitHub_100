// url: https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/

class Solution {

    Map<Integer, List<Integer>> graphMap;

    public int dfs(int node, int parent, List<Boolean> hasApple) {
        int time = 0, subTime = 0;
        for(int i: graphMap.get(node)) {
            if(i == parent) continue;
            subTime = dfs(i, node, hasApple);
            if(subTime > 0 || hasApple.get(i)) time += 2 + subTime;
        }
        return time;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        graphMap = new HashMap<>();
        for(int[] edge: edges) {
            if(!graphMap.containsKey(edge[0])) graphMap.put(edge[0], new ArrayList<>());
            graphMap.get(edge[0]).add(edge[1]);
            if(!graphMap.containsKey(edge[1])) graphMap.put(edge[1], new ArrayList<>());
            graphMap.get(edge[1]).add(edge[0]);
        }
        return dfs(0, -1, hasApple);
    }
}
