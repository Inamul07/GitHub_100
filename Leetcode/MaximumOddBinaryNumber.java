// url: https://leetcode.com/problems/maximum-odd-binary-number/

class Solution {
    public String maximumOddBinaryNumber(String s) {
        int oneCount = 0, zeroCount = 0;
        for(char ch: s.toCharArray()) {
            if(ch == '0') zeroCount++;
            else oneCount++;
        }
        if(oneCount == 0) return s;
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < oneCount-1; i++) res.append("1");
        for(int i = 0; i < zeroCount; i++) res.append("0");
        res.append("1");
        return res.toString();
    }
}
