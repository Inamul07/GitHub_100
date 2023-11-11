// url: https://leetcode.com/problems/design-graph-with-shortest-path-calculator/

class Pair {
    int x, cost;

    Pair(int x, int cost) {
        this.x = x;
        this.cost = cost;
    }
}

class Graph {

    Map<Integer, List<Pair>> map; 

    public Graph(int n, int[][] edges) {
        map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(i, new ArrayList<>());
        for(int[] edge: edges) addEdge(edge);
    }
    
    public void addEdge(int[] edge) {
        map.get(edge[0]).add(new Pair(edge[1], edge[2]));
    }
    
    public int shortestPath(int node1, int node2) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        Set<Integer> visited = new HashSet<>();
        pq.add(new Pair(node1, 0));
        while(!pq.isEmpty()) {
            Pair node = pq.remove();
            if(visited.contains(node.x)) continue;
            if(node.x == node2) return node.cost;
            for(Pair nei: map.get(node.x)) pq.add(new Pair(nei.x, nei.cost + node.cost));
            visited.add(node.x);
        }
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
