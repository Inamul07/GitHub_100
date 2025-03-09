// url: https://leetcode.com/problems/alternating-groups-ii/

class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int start = 0, end = 0, prev = -1, res = 0, rounded = 0;
        while(start < colors.length) {
            if(prev != -1) {
                if(prev == colors[end] && end < start) break;
                else if(prev == colors[end]) start = end;
                else if((end + (rounded * colors.length)) - start + 1 == k) {
                    res++;
                    start++;
                }
            }
            prev = colors[end];
            end++;
            if(end == colors.length) {
                rounded++;
                end %= colors.length;
            }
        }
        return res;
    }
}
