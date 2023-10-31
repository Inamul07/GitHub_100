// url: https://leetcode.com/problems/find-the-original-array-of-prefix-xor/

class Solution {
    public int[] findArray(int[] pref) {
        int num = pref[0];
        for(int i = 1; i < pref.length; i++) {
            pref[i] ^= num;
            num ^= pref[i];
        }
        return pref;
    }
}
