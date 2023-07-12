// url: https://leetcode.com/problems/find-eventual-safe-states/

class Solution {
    Map<Integer, List<Integer>> map;
    List<Integer> res;
    Set<Integer> visited, marked;

    private boolean dfs(int node) {
        if(visited.contains(node)) return false;
        if(marked.contains(node)) return true;
        visited.add(node);
        for(int child: map.get(node)) if(!dfs(child)) return false;
        visited.remove(node);
        marked.add(node);
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        res = new ArrayList<>();
        map = new HashMap<>();
        visited = new HashSet<>();
        marked = new HashSet<>();
        for(int i = 0; i < graph.length; i++) {
            map.put(i, new ArrayList<>());
            for(int j = 0; j < graph[i].length; j++) map.get(i).add(graph[i][j]);
        }
        for(int i = 0; i < graph.length; i++) if(dfs(i)) res.add(i);
        return res;
    }
}
