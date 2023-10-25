// url: https://leetcode.com/problems/k-th-symbol-in-grammar/

class Solution {
    public int kthGrammar(int n, int k) {
        int res = 0, l = 1, r = (int) Math.pow(2, n-1);
        for(int i = 0; i < n-1; i++) {
            int mid = l + (r - l) / 2;
            if(k <= mid) r = mid;
            else {
                l = mid + 1;
                res = res == 0? 1: 0;
            }
        }
        return res;
    }
}
/*
0
01
0110
01101001
0110100110010110
01101001100101101001011001101001
0110100110010110100101100110100110010110011010010110100110010110
*/
