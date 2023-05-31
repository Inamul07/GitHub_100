// url: https://leetcode.com/problems/string-to-integer-atoi/

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;
        double num = 0;
        int i = 0, sign = 1;
        if(s.charAt(i) == '+') i++;
        else if(s.charAt(i) == '-') {
            i++;
            sign = -1;
        }
        while(i < s.length() && Character.isDigit(s.charAt(i))) {
            num = (num*10) + (s.charAt(i)-'0');
            i++;
        }
        num *= sign;
        num = (num > Integer.MAX_VALUE) ? Integer.MAX_VALUE : num;
        num = (num < Integer.MIN_VALUE) ? Integer.MIN_VALUE : num;
        return (int) num;
    }
}
