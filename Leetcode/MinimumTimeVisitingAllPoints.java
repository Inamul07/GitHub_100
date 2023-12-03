// url: https://leetcode.com/problems/minimum-time-visiting-all-points/

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        for(int i = 0; i < points.length-1; i++) {
            int v1 = Math.abs(points[i][0]-points[i+1][0]);
            int v2 = Math.abs(points[i][1]-points[i+1][1]);
            res += Math.max(v1, v2);
        }
        return res;
    }
}
