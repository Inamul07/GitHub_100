// url: https://leetcode.com/problems/integer-break/

class Solution {

    Map<Integer, Integer> map;

    private int dfs(int num, int n) {
        if(num == 1) return 1;
        if(map.containsKey(num)) return map.get(num);
        int res = (num == n)? 0: num;
        for(int i = 1; i < num; i++) {
            int val = dfs(i, n) * dfs(num - i, n);
            res = Math.max(res, val);
        }
        map.put(num, res);
        return res;
    }

    public int integerBreak(int n) {
        map = new HashMap<>();
        return dfs(n, n);
    }
}
