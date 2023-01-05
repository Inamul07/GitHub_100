// url: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 1) return 1;
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int arrows = 1, start = points[1][0], end = points[0][1];
        for(int i = 1; i < points.length; i++) {
            if(start > end) {
                arrows++;
                end = points[i][1];
            } 
            if(points[i][1] < end) end = points[i][1];
            if(i != points.length-1) start = points[i+1][0];
        }
        return arrows;
    }
}
