// url: https://leetcode.com/problems/neighboring-bitwise-xor/
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int[] og = new int[derived.length];
        for(int i = 0; i < derived.length; i++) {
            int nextIdx = (i+1) % derived.length;
            int nextNum = 0;
            if((derived[i] == 0 && og[i] != 0) || (derived[i] == 1 && og[i] == 0)) nextNum = 1;
            if(nextIdx == 0 && og[nextIdx] != nextNum) return false;
            og[nextIdx] = nextNum;
        }
        return true;
    }
}
