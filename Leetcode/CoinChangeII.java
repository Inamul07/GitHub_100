// url: https://leetcode.com/problems/coin-change-ii/

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        for(int i = 0; i < coins.length; i++) {
            for(int j = 0; j < amount+1; j++) {
                if(i == 0) dp[j] = (j % coins[i] == 0)? 1: 0;
                else if(j < coins[i]) continue;
                else dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
