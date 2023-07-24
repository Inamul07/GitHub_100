// url: https://leetcode.com/problems/spiral-matrix/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        boolean ris = false, rds = false, cis = true, cds = false;
        int row = 0, col = 0, t = -1, r = matrix[0].length, b = matrix.length, l = -1;
        List<Integer> res = new ArrayList<>();
        while(res.size() < matrix.length * matrix[0].length) {
            res.add(matrix[row][col]);
            if(cis) col++;
            else if(cds) col--;
            if(ris) row++;
            else if(rds) row--;
            if(cis && col == r) {
                t++;
                ris = true; cis = false;
                row++; col--;
            } else if(ris && row == b) {
                r--;
                cds = true; ris = false;
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
