// url: https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/

class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < grid.length; i++) for(int j = 0; j < grid[0].length; j++) list.add(grid[i][j]);
        Collections.sort(list);
        int mid = list.get(list.size()/2), res = 0;
        for(int i = 0; i < list.size(); i++) {
            if(i == list.size() / 2) continue;
            int diff = Math.abs(mid - list.get(i));
            if(diff % x != 0) return -1;
            res += diff / x;
        }
        return res;
    }
}
