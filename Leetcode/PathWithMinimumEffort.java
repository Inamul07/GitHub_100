// url: https://leetcode.com/problems/path-with-minimum-effort/

class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2]-b[2]);
        int[][] visited = new int[heights.length][heights[0].length];
        for(int[] row: visited) Arrays.fill(row, Integer.MAX_VALUE);
        pq.add(new int[] {0, 0, 0});
        while(!pq.isEmpty()) {
            int[] node = pq.remove();
            int r = node[0], c = node[1], maxEffort = node[2];
            if(maxEffort > visited[r][c]) continue;
            if(r == heights.length-1 && c == heights[0].length-1) return maxEffort;
            visited[r][c] = maxEffort;
            int[][] coords = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
            for(int[] coord: coords) {
                int nr = r + coord[0], nc = c + coord[1];
                if(nr < 0 || nr >= heights.length || nc < 0 || nc >= heights[0].length) continue;
                int effort = Math.max(node[2], Math.abs(heights[r][c] - heights[nr][nc]));
                if(visited[nr][nc] == effort) continue;
                if(effort < visited[nr][nc]) {
                    pq.add(new int[] {nr, nc, effort});
                    visited[nr][nc] = effort;
                }
            }
        }
        return 0;
    }
}
