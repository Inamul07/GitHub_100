// url: https://leetcode.com/problems/calculate-money-in-leetcode-bank/

class Solution {

    private int sumOfN(int n) {
        return (n * (n + 1)) / 2;
    }

    public int totalMoney(int n) {
        int count = 0, res = 0;
        while(n >= 7) {
            res += (sumOfN(7 + count) - sumOfN(count));
            count++;
            n -= 7;
        }
        res += (sumOfN(n + count) - sumOfN(count));
        return res;
    }
}
