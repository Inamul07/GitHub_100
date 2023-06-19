// url: https://leetcode.com/problems/find-the-highest-altitude/

class Solution {
    public int largestAltitude(int[] gain) {
        int maxAlt = 0, alt = 0;
        for(int i = 0; i < gain.length; i++) {
            alt += gain[i];
            maxAlt = Math.max(maxAlt, alt);
        }
        return maxAlt;
    }
}
