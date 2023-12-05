// url: https://leetcode.com/problems/count-of-matches-in-tournament/

class Solution {
    public int numberOfMatches(int n) {
        if(n == 1) return 0;
        return (n/2) + numberOfMatches((n/2) + (n%2));
    }
}
