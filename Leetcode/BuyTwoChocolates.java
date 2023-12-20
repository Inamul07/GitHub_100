// url: https://leetcode.com/problems/buy-two-chocolates/

class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int amtNeeded = prices[0] + prices[1];
        if(money - amtNeeded < 0) return money;
        return money - amtNeeded;
    }
}
