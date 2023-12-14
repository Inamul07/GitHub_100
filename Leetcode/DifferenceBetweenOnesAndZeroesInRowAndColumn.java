// url: https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/

class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int[] rowSum = new int[grid.length], colSum = new int[grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            int sum = 0;
            for(int j = 0; j < grid[0].length; j++) {
                sum += grid[i][j];
                colSum[j] += grid[i][j];
            }
            rowSum[i] += sum;
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                int ro = rowSum[i], rz = grid[0].length - rowSum[i];
                int co = colSum[j], cz = grid.length - colSum[j];
                grid[i][j] = ro + co - rz - cz;
            }
        }
        return grid;
    }
}
