// url: https://leetcode.com/problems/min-cost-to-connect-all-points/

class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        Set<Integer> visited = new HashSet<>();
        pq.add(new int[] {0, 0});
        int res = 0;
        while(visited.size() < points.length) {
            int[] node = pq.remove();
            if(visited.contains(node[0])) continue;
            visited.add(node[0]);
            res += node[1];
            for(int i = 0; i < points.length; i++) {
                if(visited.contains(i)) continue;
                int dist = Math.abs(points[i][0] - points[node[0]][0]) + Math.abs(points[i][1] - points[node[0]][1]);
                pq.add(new int[] {i, dist});
            }
        }
        return res;
    }
}
