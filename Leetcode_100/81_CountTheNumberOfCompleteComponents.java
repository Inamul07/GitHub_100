// url: https://leetcode.com/problems/count-the-number-of-complete-components/

class Pair {
    int vertices, edges;

    Pair() {
        this.vertices = 0;
        this.edges = 0;
    }
}

class Solution {

    Map<Integer, List<Integer>> map;
    Set<Integer> visited;

    private void dfs(int node, int parent, Pair stat, Set<String> edgeSet) {
        if(visited.contains(node)) return;
        visited.add(node);
        stat.vertices++;
        for(int child: map.get(node)) {
            if(child == parent) continue;
            if(!(edgeSet.contains(node + "," + child) || edgeSet.contains(child + "," + node))) {
                stat.edges++;
                edgeSet.add(node + "," + child);
                edgeSet.add(child + "," + node);
            }
            dfs(child, node, stat, edgeSet);
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        map = new HashMap<>();
        visited = new HashSet<>();
        int res = 0;
        for(int i = 0; i < n; i++) map.put(i, new ArrayList<>());
        for(int[] edge: edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        for(int i = 0; i < n; i++) {
            if(visited.contains(i)) continue;
            Pair stat = new Pair();
            Set<String> edgeSet = new HashSet<>();
            dfs(i, -1, stat, new HashSet<>());
            int numVertices = stat.vertices, numEdges = stat.edges;
            if((numVertices * (numVertices - 1)) / 2 == numEdges) res++;
        }
        return res;
    }
}
