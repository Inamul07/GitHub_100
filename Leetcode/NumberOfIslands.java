// url: https://leetcode.com/problems/number-of-islands/

class Solution {

    Set<String> visited = new HashSet<>();

    private boolean isValidPos(int i, int j, char[][] grid) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    private void bfs(int r, int c, char[][] grid) {
        int[][] coords = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        visited.add(r + "," + c);
        while(!q.isEmpty()) {
            int[] node = q.remove();
            for(int[] coord: coords) {
                int nr = node[0] + coord[0], nc = node[1] + coord[1];
                if(isValidPos(nr, nc, grid) && grid[nr][nc] == '1' && !visited.contains(nr + "," + nc)) {
                    q.add(new int[] {nr, nc});
                    visited.add(nr + "," + nc);
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !visited.contains(i + "," + j)) {
                    res++;
                    bfs(i, j, grid);
                }
            }
        }
        return res;
    }
}
