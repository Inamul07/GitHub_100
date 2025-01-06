// url: https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/?envType=daily-question&envId=2025-01-06
class Solution {
    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];
        int box = 0, moves = 0, currIdx = 0;
        boolean rev = false;
        while(!(currIdx == -1 && rev)) {
            ans[currIdx] += (box + moves);
            moves += box;
            if(boxes.charAt(currIdx) == '1') box++;
            if(!rev) currIdx++;
            else currIdx--;
            if(currIdx == boxes.length()) {
                currIdx--;
                rev = true;
                box = 0;
                moves = 0;
            }
        }
        return ans;
    }
}
