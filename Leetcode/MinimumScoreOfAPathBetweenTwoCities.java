// url: https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/

class Solution {

    int minVal = Integer.MAX_VALUE;
    Set<Integer> visited = new HashSet<>();
    Map<Integer, List<List<Integer>>> map = new HashMap<>();

    public void dfs(int node, int parent) {
        if(visited.contains(node)) return;
        visited.add(node);
        for(List<Integer> list: map.get(node)) {
            if(list.get(0) == parent) continue;
            minVal = Math.min(minVal, list.get(1));
            dfs(list.get(0), node);
        }
    }

    public int minScore(int n, int[][] roads) {
        for(int[] road: roads) {
            map.putIfAbsent(road[0], new ArrayList<>());
            map.putIfAbsent(road[1], new ArrayList<>());
            List<Integer> val1 = new ArrayList<>(), val2 = new ArrayList<>();
            val1.add(road[1]); val1.add(road[2]);
            map.get(road[0]).add(val1);
            val2.add(road[0]); val2.add(road[2]);
            map.get(road[1]).add(val2);
        }
        dfs(1, 0);
        return minVal;
    }
}
