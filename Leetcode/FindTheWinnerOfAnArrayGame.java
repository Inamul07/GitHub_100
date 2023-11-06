// url: https://leetcode.com/problems/find-the-winner-of-an-array-game/

class Solution {
    public int getWinner(int[] arr, int k) {
        int max = Math.max(arr[0], arr[1]), streak = 1;
        for(int i = 2; i < arr.length; i++) {
            if(streak == k) return max;
            int currMax = Math.max(max, arr[i]);
            if(currMax == max) streak++;
            else {
                max = Math.max(currMax, max);
                streak = 1;
            }
        }
        return max;
    }
}
