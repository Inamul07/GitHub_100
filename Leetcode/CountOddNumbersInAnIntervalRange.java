// url: https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/

class Solution {
    public int countOdds(int low, int high) {
        if((high - low + 1)%2 == 0) return (high - low + 1) / 2;
        int val = 0;
        if(low%2 != 0) val++;
        return ((high - low + 1) / 2) + val;
    }
}
