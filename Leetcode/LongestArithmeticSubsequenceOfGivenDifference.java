// url: https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/

class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
           map.put(arr[i], map.getOrDefault(arr[i] - diff, 0) + 1);
           res = Math.max(res, map.get(arr[i]));
        }
       return res;
    }
}
