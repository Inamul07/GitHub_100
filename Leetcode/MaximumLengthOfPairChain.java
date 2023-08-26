// url: https://leetcode.com/problems/maximum-length-of-pair-chain/

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int res = 1, prevEnd = pairs[0][1];
        for(int i = 1; i < pairs.length; i++) {
            if(pairs[i][0] <= prevEnd) continue;
            res++;
            prevEnd = Math.max(prevEnd, pairs[i][1]);
        }
        return res;
    }
}
