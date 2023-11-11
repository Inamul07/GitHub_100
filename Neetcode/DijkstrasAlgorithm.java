// url: https://neetcode.io/problems/dijkstra

class Pair {
    int x, cost;

    Pair(int x, int cost) {
        this.x = x;
        this.cost = cost;
    }
}

class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, List<Pair>> map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(i, new ArrayList<>());
        for(List<Integer> edge: edges) map.get(edge.get(0)).add(new Pair(edge.get(1), edge.get(2)));

        Map<Integer, Integer> dist = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        for(int i = 0; i < n; i++) dist.put(i, Integer.MAX_VALUE);
        dist.put(src, 0);
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()) {
            Pair node = pq.remove();
            if(visited.contains(node.x)) continue;
            for(Pair nei: map.get(node.x)) {
                dist.put(nei.x, Math.min(node.cost + nei.cost, dist.get(nei.x)));
                pq.add(new Pair(nei.x, dist.get(nei.x)));
            }
            visited.add(node.x);
        }
        for(int i: map.keySet()) if(dist.get(i) == Integer.MAX_VALUE) dist.put(i, -1);
        return dist;
    }  
}
