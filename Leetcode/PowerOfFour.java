// url: https://leetcode.com/problems/power-of-four/

class Solution {
    public boolean isPowerOfFour(int n) {
        if(n == 0) return false;
        int pow = (int) (Math.log(n) / Math.log(4));
        if((int) Math.pow(4, pow) == n) return true;
        return false;
    }
}
