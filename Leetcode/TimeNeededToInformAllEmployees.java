// url: https://leetcode.com/problems/time-needed-to-inform-all-employees/

class Solution {

    Map<Integer, List<Integer>> map;
    int maxTime = 0;
    
    public void dfs(int node, int parent, int time, int[] informTime) {
        if(!map.containsKey(node)) return;
        for(int child: map.get(node)) {
            if(child == parent) continue;
            maxTime = Math.max(maxTime, time);
            dfs(child, node, time + informTime[child], informTime);
        }
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if(n == 1) return 0;
        map = new HashMap<>();
        for(int i = 0; i < manager.length; i++) {
            if(manager[i] == -1) continue;
            map.putIfAbsent(manager[i], new ArrayList<>());
            map.get(manager[i]).add(i);
        }
        System.out.print(map);
        dfs(headID, -1, informTime[headID], informTime);
        return maxTime;
    }
}
