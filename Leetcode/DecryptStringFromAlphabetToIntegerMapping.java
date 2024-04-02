// url: https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/

class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '#') continue;
            if(i + 2 < s.length() && s.charAt(i + 2) == '#') {
                int num = Integer.parseInt(s.substring(i, i+2));
                sb.append((char) (num + 'a' - 1));
            } else if(i + 1 < s.length() && s.charAt(i + 1) == '#') continue;
            else {
                int num = s.charAt(i) - '0';
                sb.append((char) (num + 'a' - 1));
            }
        }
        return sb.toString();
    }
}
