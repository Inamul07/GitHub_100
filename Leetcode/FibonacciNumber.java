// 509. Fibonacci Number
// https://leetcode.com/problems/fibonacci-number/

class Solution {
    public int fib(int n) {
        int[] fibo = new int[n+2];
        fibo[0] = 0;
        fibo[1] = 1;
        for(int i = 2; i <= n; i++) fibo[i] = fibo[i - 1] + fibo[i - 2];
        return fibo[n];
    }
}