// 1091. Shortest Path in Binary Matrix
// https://leetcode.com/problems/shortest-path-in-binary-matrix/

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 1});
        grid[0][0] = 1;
        int[][] cor = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        while(!q.isEmpty()) {
            int[] idx = q.poll();
            if(idx[0] == m-1 && idx[1] == n-1) return idx[2];
            for(int[] d: cor) {
                int row = idx[0] + d[0], col = idx[1] + d[1];
                if(row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 0) {
                    q.add(new int[] {row, col, idx[2]+1});
                    grid[row][col] = 1;
                }
            }
        }
        return -1;
    }
}