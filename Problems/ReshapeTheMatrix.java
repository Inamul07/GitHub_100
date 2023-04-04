// url: https://leetcode.com/problems/reshape-the-matrix

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length * mat[0].length != r * c) return mat;
        int[][] res = new int[r][c];
        int rPtr = 0, cPtr = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                res[i][j] = mat[rPtr][cPtr];
                if(++cPtr == mat[0].length) {
                    rPtr++;
                    cPtr = 0;
                }
            }
        }
        return res;
    }
}
