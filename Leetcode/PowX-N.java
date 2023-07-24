// url: https://leetcode.com/problems/powx-n/

class Solution {

    private double pow(double x, long n) {
        if(n == 0) return 1.0;
        if(n < 0) return 1.0 / pow(x, -1 * n);
        if(n%2 == 1) return x * pow(x * x, (n-1) / 2);
        return pow(x * x, n/2);
    }

    public double myPow(double x, int n) {
        return pow(x, n);
    }
}
