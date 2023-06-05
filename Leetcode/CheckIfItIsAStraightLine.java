// url: https://leetcode.com/problems/check-if-it-is-a-straight-line/

class Solution {
    public boolean checkStraightLine(int[][] coord) {
        int x1 =  coord[0][0], x2 = coord[1][0], y1 = coord[0][1], y2 = coord[1][1];
        for(int i = 2; i < coord.length; i++) { 
            int x = coord[i][0], y = coord[i][1];
            if((y - y1) * (x2 - x1) != (x - x1) * (y2 - y1))return false;
        }
        return true;
    }
}
