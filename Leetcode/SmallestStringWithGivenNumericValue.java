// url: https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/

class Solution {
    public String getSmallestString(int n, int k) {
        char[] resArr = new char[n];
        Arrays.fill(resArr, 'a');
        int score = n, idx = n-1;
        while(score < k) {
            score -= 1;
            int reqChar = Math.min(k - score, 26);
            resArr[idx] = (char) ('a' + reqChar - 1);
            score += reqChar;
            idx--;
        }
        return new String(resArr);
    }
}
