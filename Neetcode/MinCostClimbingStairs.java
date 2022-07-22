// url: https://leetcode.com/problems/min-cost-climbing-stairs/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int v1 = 0, v2 = cost[cost.length-1];
        for(int i = cost.length-2; i >= 0; i--) {
            cost[i] = Math.min(cost[i]+v1, cost[i]+v2);
            v1 = v2;
            v2 = cost[i];
        }
        return Math.min(cost[0], cost[1]);
    }
}