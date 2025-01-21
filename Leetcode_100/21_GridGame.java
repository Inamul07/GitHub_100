// url: https://leetcode.com/problems/grid-game/

class Solution {
    public long gridGame(int[][] grid) {
        long row1Sum = 0, row2Sum = 0;
        for(int i = 0; i < grid[0].length; i++) row1Sum += grid[0][i];
        long maxPoints = Long.MAX_VALUE;
        for(int i = 0; i < grid[0].length; i++) {
            row1Sum -= grid[0][i];
            long remPoints = Math.max(row1Sum, row2Sum);
            maxPoints = Math.min(maxPoints, remPoints);
            row2Sum += grid[1][i];
        }
        return maxPoints;
    }
}
