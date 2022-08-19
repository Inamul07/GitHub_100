// url: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length < 2 || k == 0) return 0;
        int[] dp = new int[prices.length];
        for(int i = 1; i <= k; i++) {
            int maxDif = 0 - prices[0];
            for(int j = 1; j < prices.length; j++) {
                int prev = dp[j];
                //Max of noSellprize and sellPrize of previous buys
                dp[j] = Math.max(dp[j-1], prices[j] + maxDif);
                maxDif = Math.max(maxDif, prev - prices[j]);
            }
        }
        return dp[dp.length-1];
    }
}