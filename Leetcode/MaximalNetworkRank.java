// url: https://leetcode.com/problems/maximal-network-rank/

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] count = new int[n];
        int[][] connected = new int[n][n];
        for(int[] road: roads) {
            count[road[0]]++;
            count[road[1]]++;
            connected[road[0]][road[1]] = 1;
            connected[road[1]][road[0]] = 1;
        }
        int res = 0;
        for(int i = 0; i < n; i++) 
            for(int j = i+1; j < n; j++) 
                res = Math.max(res, count[i] + count[j] - connected[i][j]);
        return res;
    }
}
