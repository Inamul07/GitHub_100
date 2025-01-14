// url: https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/
class Solution {
    public int minimumLength(String s) {
        int[] alpha = new int[26];
        int len = 0;
        for(int i = 0; i < s.length(); i++) alpha[s.charAt(i)-'a']++;
        for(int i = 0; i < 26; i++) {
            if(alpha[i] != 0 && alpha[i]%2 == 0) len += 2;
            else if(alpha[i] != 0) len += 1;
        }
        return len;
    }
}
// Forgot to Upload yesterday :(
