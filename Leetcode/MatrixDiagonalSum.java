// url: https://leetcode.com/problems/matrix-diagonal-sum/

class Solution {
    public int diagonalSum(int[][] mat) {
        int start = 0, end = mat[0].length-1, sum = 0;
        for(int i = 0; i < mat.length; i++) {
            sum += mat[i][start];
            if(start != end) sum += mat[i][end];
            start++;
            end--;
        }
        return sum;
    }
}
