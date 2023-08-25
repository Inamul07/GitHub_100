// url: https://leetcode.com/problems/interleaving-string/

class Solution {

    int[][] dp;

    private boolean backtrack(int i, int j, String s1, String s2, String s3) {
        if(i >= s1.length() && j >= s2.length()) return true;
        if(i < s1.length() && j < s2.length() && dp[i][j] != 0) return dp[i][j] == 1? true: false;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j) && backtrack(i+1, j, s1, s2, s3)) {
            dp[i][j] = 1;
            return true;
        }
        if(j < s2.length() && s2.charAt(j) == s3.charAt(i+j) && backtrack(i, j+1, s1, s2, s3)) {
            dp[i][j] = 1;
            return true;
        }
        if(i < s1.length() && j < s2.length()) dp[i][j] = 2;
        return false;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        dp = new int[s1.length() + s2.length()][s1.length() + s2.length()]; 
        return backtrack(0, 0, s1, s2, s3);
    }
}
