// url: https://leetcode.com/problems/find-the-difference/

class Solution {
    public char findTheDifference(String s, String t) {
        int bit = 0;
        for(char ch: s.toCharArray()) bit ^= ch;
        for(char ch: t.toCharArray()) bit ^= ch;
        return (char) bit;
    }
}
