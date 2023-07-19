// url: https://leetcode.com/problems/non-overlapping-intervals/

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1]-b[1]);
        int res = 0, k = Integer.MIN_VALUE;
        for(int[] interval: intervals) {
            if(interval[0] >= k) k = interval[1];
            else res++;
        }
        return res;
    }
}
