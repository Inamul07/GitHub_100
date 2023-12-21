// url: https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int res = 0;
        Arrays.sort(points, (a, b) -> a[0]-b[0]);
        for(int i = 1; i < points.length; i++) res = Math.max(points[i][0] - points[i-1][0], res);
        return res;
    }
}
