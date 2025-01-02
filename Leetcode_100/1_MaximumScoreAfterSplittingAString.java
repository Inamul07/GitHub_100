// url: https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/?envType=daily-question&envId=2025-01-02
class Solution {
    public int maxScore(String s) {
        int zCount = 0, oCount = 0;
        int max = -1;
        for(int i = s.length()-1; i >= 0; i--) oCount += (s.charAt(i) - '0');
        for(int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) == '0') zCount++;
            else oCount--;
            max = Math.max(max, zCount + oCount);
        }
        return max;
    }
}
