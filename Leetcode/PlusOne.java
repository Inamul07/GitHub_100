// url: https://leetcode.com/problems/plus-one/

class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length-1; i >= 0; i--) {
            digits[i] += carry;
            carry = 0;
            if(digits[i] == 10) {
                carry = 1;
                digits[i] = 0;
            }
        }
        if(carry == 1) {
            digits = Arrays.copyOf(digits, digits.length+1);
            for(int i = digits.length-1; i > 0; i--) digits[i] = digits[i-1];
            digits[0] = 1;
        }
        return digits;
    }
}
