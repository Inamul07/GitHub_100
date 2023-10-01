// url: https://leetcode.com/problems/reverse-words-in-a-string-iii/

class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length; i++) {
            sb.append(new StringBuilder(str[i]).reverse().toString());
            if(i != str.length-1) sb.append(" ");
        }
        return sb.toString();
    }
}
