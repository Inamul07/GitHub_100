// url: https://leetcode.com/problems/unique-paths-ii/

class Solution {

    Map<String, Integer> map;

    public int uniquePaths(int i, int j, int[][] obstacleGrid) {
        int r = obstacleGrid.length, c = obstacleGrid[0].length;
        if(i >= r || j >= c || obstacleGrid[i][j] == 1) return 0;
        if(i == r-1 && j == c-1) return 1;
        if(map.containsKey(i + "," + j)) return map.get(i + "," + j);
        int res = uniquePaths(i+1, j, obstacleGrid) + uniquePaths(i, j+1, obstacleGrid);
        map.put(i + "," + j, res);
        return res;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        map = new HashMap<>();
        return uniquePaths(0, 0, obstacleGrid);
    }
}
