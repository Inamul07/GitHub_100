// url: https://leetcode.com/problems/richest-customer-wealth/

class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for(int[] account: accounts) {
            int wealth = 0;
            for(int i: account) wealth += i;
            maxWealth = Math.max(wealth, maxWealth);
        }
        return maxWealth;
    }
}
