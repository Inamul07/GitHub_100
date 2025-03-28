// url: https://leetcode.com/problems/maximum-number-of-points-from-grid-queries/

class Solution {

    private static final int[][] COORDS = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public int[] maxPoints(int[][] grid, int[] queries) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        Set<String> visited = new HashSet<>();
        List<int[]> queryList = new ArrayList<>();
        for(int i = 0; i < queries.length; i++) queryList.add(new int[] {queries[i], i});
        Collections.sort(queryList, (a, b) -> a[0] - b[0]);
        pq.add(new int[] {0, 0, grid[0][0]});
        visited.add("0,0");
        int currIdx = 0, currPoints = 0;
        int[] res = new int[queries.length];
        for(int[] q: queryList) {
            while(!pq.isEmpty() && pq.peek()[2] < q[0]) {
                int[] node = pq.remove();
                currPoints++;
                for(int[] coord: COORDS) {
                    int nr = node[0] + coord[0], nc = node[1] + coord[1];
                    if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || visited.contains(nr + "," + nc)) continue;
                    pq.add(new int[] {nr, nc, grid[nr][nc]});
                    visited.add(nr + "," + nc);
                }
            }
            res[q[1]] = currPoints;
        }
        return res;
    }
}
