// url: https://leetcode.com/problems/add-to-array-form-of-integer/

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int idx = num.length-1, carry = 0;
        while(idx >= 0 || k > 0) {
            int val = 0;
            if(idx >= 0) val = (k%10) + num[idx] + carry;
            else val = (k%10) + carry;
            carry = 0;
            if(val > 9) {
                res.add(val%10);
                carry = val / 10;
            } else {
                res.add(val);
            }
            k /= 10;
            idx--;
        }
        if(carry != 0) res.add(carry);
        Collections.reverse(res);
        return res;
    }
}
