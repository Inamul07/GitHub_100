// url: https://leetcode.com/problems/maximum-ice-cream-bars/

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0, coinsSpent = 0;
        for(int i = 0; i < costs.length; i++) {
            if(coinsSpent + costs[i] <= coins) {
                res++;
                coinsSpent += costs[i];
            } else break;
        }
        return res;
    }
}
