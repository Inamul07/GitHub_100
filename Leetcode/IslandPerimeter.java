// url: https://leetcode.com/problems/island-perimeter/

class Solution {

    private int checkSurroundings(int i, int j, int[][] grid) {
        int res = 4;
        int[][] coords = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        for(int[] coord: coords) {
            int nr = i + coord[0], nc = j + coord[1];
            if(nr >= grid.length || nc >= grid[0].length || nr < 0 || nc < 0) continue;
            if(grid[nr][nc] == 1) res--;
        }
        return res;
    }

    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) res += checkSurroundings(i, j, grid);
            }
        }
        return res;
    }
}
