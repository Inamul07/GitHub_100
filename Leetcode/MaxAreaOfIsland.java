// url: https://leetcode.com/problems/max-area-of-island/

class Solution {

    int maxArea;
    Set<String> visited;

    private void bfs(int r, int c, int[][] grid) {
        if(visited.contains(r + "," + c)) return;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        visited.add(r + "," + c);
        int area = 1;
        while(!q.isEmpty()) {
            int[] node = q.remove();
            int[][] coords = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
            for(int[] coord: coords) {
                int nr = node[0] + coord[0], nc = node[1] + coord[1];
                if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || visited.contains(nr + "," + nc)) continue;
                if(grid[nr][nc] == 1) {
                    area++;
                    q.add(new int[] {nr, nc});
                }
                visited.add(nr + "," + nc);
            }
            maxArea = Math.max(maxArea, area);
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        maxArea = 0;
        visited = new HashSet<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1 && !visited.contains(i + "," + j)) bfs(i, j, grid);
            }
        }
        return maxArea;
    }
}
