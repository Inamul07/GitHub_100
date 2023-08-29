// url: https://leetcode.com/problems/minimum-penalty-for-a-shop/

class Solution {
    public int bestClosingTime(String customers) {
        int yCount = 0, nCount = 0, minPenalty = Integer.MAX_VALUE, res = -1;
        for(int i = 0; i < customers.length(); i++) if(customers.charAt(i) == 'Y') yCount++;
        for(int i = 0; i <= customers.length(); i++) {
            if(yCount + nCount < minPenalty) {
                minPenalty = yCount + nCount;
                res = i;
            }
            if(i != customers.length() && customers.charAt(i) == 'Y') yCount--;
            else if(i != customers.length() && customers.charAt(i) == 'N') nCount++;
        }
        return res;
    }
}
