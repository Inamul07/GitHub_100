// url: https://leetcode.com/problems/minimum-time-to-repair-cars/

class Solution {
    public long repairCars(int[] ranks, int cars) {
        int max = 0;
        for(int rank: ranks) max = Math.max(max, rank);
        long l = 1, r = (max * (long) cars) * (long) cars, res = 0;
        while(l <= r) {
            long mid = l + (r - l) / 2;
            long carSum = 0;
            for(int rank: ranks) carSum += (long) Math.sqrt(mid / rank);
            if(carSum >= cars) {
                res = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return res;
    }
}

/*
To Search if a mid (time) value is valid, we use the equation: time = r * n^2
Solving this,
n = sqrt(time / r)
*/
