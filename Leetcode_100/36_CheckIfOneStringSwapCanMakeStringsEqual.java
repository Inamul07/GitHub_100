// url: https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        char diff1 = '0', diff2 = '0', act1 = '0', act2 = '0';
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if(diff1 == '0') {
                    diff1 = s1.charAt(i);
                    act1 = s2.charAt(i);
                } else if(diff2 == '0') {
                    diff2 = s1.charAt(i);
                    act2 = s2.charAt(i);
                } else return false;
            }
        }
        return diff1 == act2 && diff2 == act1;
    }
}
