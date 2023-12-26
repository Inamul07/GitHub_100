// url: https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

class Solution {

    Map<String, Integer> map;
    final int MOD = (int) Math.pow(10, 9) + 7;

    private int dfs(int n, int k, int target) {
        if(n == 0 && target == 0) return 1;
        if(n == 0 || target < 0) return 0;
        if(map.containsKey(n + "," + target)) return map.get(n + "," + target);
        long res = 0;
        for(int i = 1; i <= k; i++) {
            res += dfs(n-1, k, target-i);
            res %= MOD;
        }
        map.put(n + "," + target, (int) res);
        return (int) res;
    }

    public int numRollsToTarget(int n, int k, int target) {
        map = new HashMap<>();
        return dfs(n, k, target);
    }
}
