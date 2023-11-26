// url: https://leetcode.com/problems/largest-submatrix-with-rearrangements/

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        for(int i = 0; i < matrix[0].length; i++) {
            for(int j = matrix.length-1; j >= 0; j--) {
                if(matrix[j][i] == 1 && j == matrix.length-1) matrix[j][i] = 1;
                else if(matrix[j][i] == 1) matrix[j][i] = matrix[j+1][i] + 1; 
            }
        }
        int res = 0;
        for(int i = 0; i < matrix.length; i++) {
            Arrays.sort(matrix[i]);
            for(int j = matrix[i].length-1; j >= 0; j--) {
                res = Math.max(res, matrix[i][j] * (matrix[i].length - j));
            }
        }
        return res;
    }
}
