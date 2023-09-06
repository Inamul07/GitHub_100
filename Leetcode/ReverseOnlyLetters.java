// url: https://leetcode.com/problems/reverse-only-letters/

class Solution {
    public String reverseOnlyLetters(String s) {
        int start = 0, end = s.length()-1;
        char[] str = s.toCharArray();
        while(start < end) {
            if(!Character.isLetter(str[start])) {
                start++;
                continue;
            }
            if(!Character.isLetter(str[end])) {
                end--;
                continue;
            }
            char tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;
            start++; end--;
        }
        return new String(str);
    }
}
