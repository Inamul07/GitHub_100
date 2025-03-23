// url: https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/

class Solution {

    private static final int MOD = (int) Math.pow(10, 9) + 7;

    public int countPaths(int n, int[][] roads) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        long[] minCost = new long[n];
        long[] pathCount = new long[n];
        pathCount[0] = 1;
        for(int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
            minCost[i] = Long.MAX_VALUE;
        }
        for(int[] road: roads) {
            map.get(road[0]).add(new int[] {road[1], road[2]});
            map.get(road[1]).add(new int[] {road[0], road[2]});
        }
        pq.add(new long[] {0l, 0l});
        while(!pq.isEmpty()) {
            long[] node = pq.remove();
            for(int[] nei: map.get((int) node[0])) {
                if(node[1] + nei[1] < minCost[nei[0]]) {
                    minCost[nei[0]] = node[1] + nei[1];
                    pathCount[nei[0]] = pathCount[(int) node[0]];
                    pq.add(new long[] {nei[0], node[1] + nei[1]});
                } else if(node[1] + nei[1] == minCost[nei[0]]) {
                    pathCount[nei[0]] = (pathCount[nei[0]] + pathCount[(int) node[0]]) % MOD;
                }
            }
        }
        return (int) pathCount[n-1];
    }
}
