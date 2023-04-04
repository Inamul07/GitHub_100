// url: https://leetcode.com/problems/search-a-2d-matrix/

class Solution {
    public boolean searchMatrix(int[][] m, int target) {
        int start = 0, end = (m.length-1) * m[0].length + (m[0].length-1);
        while(start <= end) {
            int mid = start + (end - start) / 2, midVal = m[mid/m[0].length][mid%m[0].length];
            if(midVal == target) return true;
            if(midVal > target) end = mid-1;
            else start = mid+1;
        }
        return false;
    }
}
