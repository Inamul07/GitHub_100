// url: https://leetcode.com/problems/add-binary/

class Solution {

    public String incLength(String s, int len) {
        while(s.length() < len) s = "0" + s;
        return s; 
    }

    public String addBinary(String a, String b) {
        if(a.length() < b.length()) a = incLength(a, b.length());
        if(b.length() < a.length()) b = incLength(b, a.length());
        int carry = 0;
        String res = "";
        for(int i = a.length()-1; i >= 0; i--) {
            if(a.charAt(i) == '0' && b.charAt(i) == '0') {
                res = carry + "" + res;
                carry = 0;
            }
            if((a.charAt(i) == '0' && b.charAt(i) == '1') || (a.charAt(i) == '1' && b.charAt(i) == '0')) {
                if(carry == 1) res = "0" + res;
                else res = "1" + res;
            }
            if(a.charAt(i) == '1' && b.charAt(i) == '1') {
                if(carry == 0) res = "0" + res;
                else res = "1" + res;
                carry = 1;
            }
        }
        if(carry == 1) res = "1" + res;
        return res;
    }
}
