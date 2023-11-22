// url: https://leetcode.com/problems/count-nice-pairs-in-an-array/

class Solution {

    private int rev(int n) {
        int res = 0;
        while(n > 0) {
            res = (res*10) + (n%10);
            n /= 10;
        }
        return res;
    }

    public int countNicePairs(int[] nums) {
        Map<Integer, Long> map = new HashMap<>();
        for(int i: nums) {
            int num = i - rev(i);
            map.put(num, map.getOrDefault(num, 0l) + 1);
        }
        System.out.print(map);
        long res = 0, mod = 1000000007;
        for(long i: map.values()) {
            long val = (i * (i-1) / 2);
            res += (val % mod);
            res %= mod;
        }
        return (int) (res%mod);
    }
}
