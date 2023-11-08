// url: https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time/

class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(sx == fx && sy == fy && t == 1) return false;
        int a1 = Math.abs(sx - fx), a2 = Math.abs(sy - fy);
        return Math.min(a1, a2) + Math.abs(a1-a2) <= t;
    }
}
