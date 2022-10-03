// url: https://leetcode.com/problems/minimum-time-to-make-rope-colorful/

class Solution {
    public int minCost(String colors, int[] neededTime) {
        int minTime = 0, l = 0, r = 0, totTime = 0, maxTime = 0;
        while(l < colors.length() && r < colors.length()) {
            if(colors.charAt(l) == colors.charAt(r)) {
                maxTime = Math.max(maxTime, neededTime[r]);
                totTime += neededTime[r];
                r++;
            } else {
                minTime += (totTime - maxTime);
                totTime = 0;
                maxTime = 0;
                l = r;
            }
        }
        minTime += (totTime - maxTime);
        return minTime;
    }
}
