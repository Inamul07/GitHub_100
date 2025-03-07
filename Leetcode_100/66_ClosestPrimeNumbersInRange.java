// url: https://leetcode.com/problems/closest-prime-numbers-in-range/

class Solution {

    private boolean isPrime(int num) {
        if(num == 1) return false;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num%i == 0) return false;
        }
        return true;
    }

    public int[] closestPrimes(int left, int right) {
        int prev = -1, minDiff = Integer.MAX_VALUE;
        int[] minDiffNums = new int[2];
        boolean assigned = false;
        for(int i = left; i <= right; i++) {
            if(isPrime(i)) {
                if(prev == -1) prev = i;
                else {
                    int diff = i - prev;
                    assigned = true;
                    if(diff < minDiff) {
                        minDiffNums[0] = prev;
                        minDiffNums[1] = i;
                        minDiff = diff;
                    }
                    if(minDiff == 2) return minDiffNums;
                    prev = i;
                }
            }
        }
        if(!assigned) return new int[] {-1, -1};
        return minDiffNums;
    }
}
