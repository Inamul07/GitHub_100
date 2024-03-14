// url: https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/

class Solution {

    private int manhattanDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    public int nearestValidPoint(int x, int y, int[][] points) {
        int res = -1, minDist = Integer.MAX_VALUE;
        for(int i = 0; i < points.length; i++) {
            if(points[i][0] == x || points[i][1] == y) {
                int manDist = manhattanDistance(new int[] {points[i][0], points[i][1]}, new int[] {x, y});
                if(manDist < minDist) {
                    minDist = manDist;
                    res = i;
                }
            }
        }
        return res;
    }
}
