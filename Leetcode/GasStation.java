// url: https://leetcode.com/problems/gas-station

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0, costSum = 0;
        int[] diff = new int[gas.length];
        for(int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }
        if(gasSum < costSum) return -1;
        int total = 0, res = 0;
        for(int i = 0; i < diff.length; i++) {
            total += (gas[i] - cost[i]);
            if(total < 0) {
                total = 0;
                res = i+1;
            } 
        }
        return res;
    }
}
