// url: https://leetcode.com/problems/maximum-candies-allocated-to-k-children/

class Solution {
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for(int candy: candies) sum += candy;
        if(sum < k) return 0;
        long l = 1, r = sum / k, res = 1;
        while(l <= r) {
            long mid = l + (r - l) / 2;
            long comp = 0;
            boolean valid = false;
            for(int candy: candies) {
                comp += (candy / mid);
                if(comp >= k) {
                    valid = true;
                    break;
                }
            }
            if(valid) {
                res = mid;
                l = mid + 1;
            } else r = mid - 1;
        }
        return (int) res;
    }
}

/*
Python Code
class Solution(object):
    def maximumCandies(self, candies, k):
        sum = 0
        for candy in candies:
            sum += candy
        if sum < k:
            return 0
        l = 1
        r = sum // k
        res = 1
        while l <= r:
            mid = l + (r - l) / 2
            comp = 0
            valid = False
            for candy in candies:
                comp += (candy // mid)
                if comp >= k:
                    valid = True
                    break
            if valid:
                res = mid
                l = mid + 1
            else:
                r = mid - 1
        return res
*/
