// url: https://leetcode.com/problems/largest-3-same-digit-number-in-string/

class Solution {
    public String largestGoodInteger(String num) {
        String res = "";
        int l = 0;
        for(int r = 2; r < num.length(); r++, l++) {
            if(num.charAt(l) == num.charAt(l+1) && num.charAt(l+1) == num.charAt(r)) {
                if(!res.isEmpty() && res.charAt(0) > num.charAt(l)) continue;
                res = num.substring(l, r+1);
            }
        }
        return res;
    }
}
