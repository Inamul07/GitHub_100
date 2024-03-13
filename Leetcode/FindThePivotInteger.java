// url: https://leetcode.com/problems/find-the-pivot-integer/

class Solution {

    private int sumOfNTerms(int n) {
        return (n * (n + 1)) / 2;
    }

    public int pivotInteger(int n) {
        int totalSum = sumOfNTerms(n);
        for(int i = 1; i <= n; i++) {
            int l = sumOfNTerms(i), r = totalSum - l + i;
            if(l == r) return i;
        }
        return -1;
    }
}
