// url: https://leetcode.com/problems/maximum-number-of-coins-you-can-get/

class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int myIdx = piles.length-2, bobIdx = 0, res = 0;
        while(myIdx > bobIdx) {
            res += piles[myIdx];
            myIdx -= 2;
            bobIdx++;
        }
        return res;
    }
}
