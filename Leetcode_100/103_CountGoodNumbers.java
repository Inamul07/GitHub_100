// url: https://leetcode.com/problems/count-good-numbers/

class Solution {

    private static final int MOD = (int) Math.pow(10, 9) + 7;

    private long pow(long x, long n) {
        long res = 1;
        while(n > 0) {
            if(n%2 != 0) res = (res * x) % MOD;
            x = (x * x) % MOD;
            n /= 2;
        }
        return res % MOD;
    }

    public int countGoodNumbers(long n) {
        long numOdd = n/2, numEven = (long) (n+1) / 2;
        return (int) ((pow(5, numEven) * pow(4, numOdd)) % MOD);
    }
}
