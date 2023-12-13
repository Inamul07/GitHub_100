// url: https://leetcode.com/problems/special-positions-in-a-binary-matrix/

class Solution {
    public int numSpecial(int[][] mat) {
        int[] rowSum = new int[mat.length], colSum = new int[mat[0].length];
        for(int i = 0; i < mat.length; i++) {
            int rSum = 0;
            for(int j = 0; j < mat[0].length; j++) {
                rSum += mat[i][j];
                colSum[j] += mat[i][j];
            }
            rowSum[i] = rSum;
        }
        int res = 0;
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1) res++;
            }
        }
        return res;
    }
}
