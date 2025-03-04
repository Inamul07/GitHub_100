// url: https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/

class Solution {
    public boolean checkPowersOfThree(int n) {
        while(n > 1) {
            if(n%3 == 2) return false;
            n /= 3;
        }
        return true;
    }
}
