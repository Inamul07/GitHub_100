// url: https://leetcode.com/problems/zigzag-conversion/

class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        String res = "";
        for(int i = 0; i < numRows; i++) {
            int inc = (numRows - 1) * 2;
            for(int j = i; j < s.length(); j += inc) {
                res += s.charAt(j);
                if(i != 0 && i != numRows - 1 && j + inc - 2 * i < s.length()) {
                    res += s.charAt(j + inc - 2 * i);
                }
            }
        }
        return res;
    }
}
