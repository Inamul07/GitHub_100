// url: https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/

class Solution {
    
    Map<Integer, List<Integer>> graphMap = new HashMap<>();
    long minFuel;

    public int dfs(int node, int parent, int seats) {
        int members = 0;
        for(int child: graphMap.get(node)) {
            if(child == parent) continue;
            int m = dfs(child, node, seats);
            members += m;
            minFuel += (long) Math.ceil((double) m / seats);
        }
        return members + 1;
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        if(roads.length == 0) return 0;
        minFuel = 0;
        for(int[] edge: roads) {
            graphMap.putIfAbsent(edge[0], new ArrayList<>());
            graphMap.putIfAbsent(edge[1], new ArrayList<>());
            graphMap.get(edge[0]).add(edge[1]);
            graphMap.get(edge[1]).add(edge[0]);
        }
        dfs(0, -1, seats);
        return minFuel;
    }
}
