// url: https://leetcode.com/problems/find-eventual-safe-states/

class Solution {

    int[][] graph;
    Set<Integer> safe;
    Set<Integer> unSafe;

    private boolean isSafe(int i, Set<Integer> path) {
        if(safe.contains(i)) return true;
        else if(unSafe.contains(i)) return false;
        else if(path.contains(i)) {
            unSafe.add(i);
            return false;
        }
        path.add(i);
        for(int child: graph[i]) {
            if(!isSafe(child, new HashSet<>(path))) return false;
        }
        safe.add(i);
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        safe = new HashSet<>();
        unSafe = new HashSet<>();
        this.graph = graph;
        for(int i = 0; i < graph.length; i++) if(isSafe(i, new HashSet<>())) res.add(i);
        return res;
    }
}
