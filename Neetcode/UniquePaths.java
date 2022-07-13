// url: https://leetcode.com/problems/unique-paths/

class Solution {
    
    private Map<String, Integer> map = new HashMap<>();
    
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) return 0;
        if(m == 1 && n == 1) return 1;
        
        String s = m + "," + n;
        if(map.containsKey(s)) return map.get(s);
        
        int res = uniquePaths(m-1, n) + uniquePaths(m, n-1);
        map.put(s, res);
        return res;
    }
}