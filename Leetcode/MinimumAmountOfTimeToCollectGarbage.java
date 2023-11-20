// url: https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/

class Solution {

    private int calculate(String[] garbage, int[] travel, int num, char type) {
        int res = 0;
        for(int i = 0; i <= num; i++) {
            for(char ch: garbage[i].toCharArray()) if(ch == type) res++;
            if(i != num) res += travel[i];
        }
        return res;
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int res = 0, p = -1, g = -1, m = -1;
        for(int i = 0; i < garbage.length; i++) {
            for(char ch: garbage[i].toCharArray()) {
                if(ch == 'M') m = i;
                else if(ch == 'P') p = i;
                else g = i;
            }
        }
        res += calculate(garbage, travel, p, 'P');
        res += calculate(garbage, travel, m, 'M');
        res += calculate(garbage, travel, g, 'G');
        return res;
    }
}
