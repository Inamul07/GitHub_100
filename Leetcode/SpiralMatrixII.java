// url: https://leetcode.com/problems/spiral-matrix-ii/

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int val = 1, row = 0, col = 0, t = -1, b = n, l = -1, r = n;
        boolean ris = false, cis = true, rds = false, cds = false;
        while(val <= n*n) {
            res[row][col] = val++;
            if(ris) row++;
            else if(rds) row--;
            else if(cis) col++;
            else col--;
            if(cis && col == r) {
                t++;
                cis = false; ris = true;
                col--; row++;
            } else if(ris && row == b) {
                r--;
                ris = false; cds = true;
                row--; col--;
            } else if(cds && col == l) {
                b--;
                cds = false; rds = true;
                col++; row--;
            } else if(rds && row == t) {
                l++;
                rds = false; cis = true;
                row++; col++;
            }
        }
        return res;
    }
}
