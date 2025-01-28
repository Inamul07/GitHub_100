// url: https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/

class Solution {

    private int dfs(int i, int j, int[][] grid) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;
        int res = grid[i][j];
        grid[i][j] = 0;
        res += dfs(i-1, j, grid);
        res += dfs(i, j-1, grid);
        res += dfs(i, j+1, grid);
        res += dfs(i+1, j, grid);
        return res;
    }

    public int findMaxFish(int[][] grid) {
        int maxFish = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) continue;
                int numFishes = dfs(i, j, grid);
                maxFish = Math.max(numFishes, maxFish);
            }
        }
        return maxFish;
    }
}
