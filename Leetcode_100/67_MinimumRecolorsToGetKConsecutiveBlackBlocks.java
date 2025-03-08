// url: https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/

class Solution {
    public int minimumRecolors(String blocks, int k) {
        int blackCount = 0, start = 0, minRes = Integer.MAX_VALUE;
        for(int i = 0; i < blocks.length(); i++) {
            if(blocks.charAt(i) == 'B') blackCount++;
            if(i >= k-1) {
                minRes = Math.min(minRes, k - blackCount);
                if(blocks.charAt(start) == 'B') blackCount--;
                start++;
            }
        }
        return minRes;
    }
}
