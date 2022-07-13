// url: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {
    public int maxProfit(int[] prices) {
        int start = 0, profit = 0;
        for(int end = 1; end < prices.length; end++) {
            if(prices[end] <= prices[start]) start = end;
            else profit = Math.max(profit, prices[end]-prices[start]);
        }
        return profit;
    }
}