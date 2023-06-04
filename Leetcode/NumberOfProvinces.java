// url: https://leetcode.com/problems/number-of-provinces/

// Breadth First Search
class Solution {

    Map<Integer, List<Integer>> map;
    Set<Integer> visited;
    int provinces = 0;

    private void bfs(int node) {
        if(visited.contains(node)) return;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited.add(node);
        provinces++;
        while(!q.isEmpty()) {
            int n = q.remove();
            for(int child: map.get(n)) {
                if(visited.contains(child)) continue;
                q.add(child);
                visited.add(child);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        map = new HashMap<>();
        visited = new HashSet<>();
        for(int i = 0; i < isConnected.length; i++) {
            map.putIfAbsent(i, new ArrayList<>());
            for(int j = 0; j < isConnected[0].length; j++) {
                if(i == j) continue;
                if(isConnected[i][j] == 1) {
                    map.get(i).add(j);
                }
            }
        }
        for(int i: map.keySet()) bfs(i);
        return provinces;
    }
}

// Union Find
class Solution {

    int[] parent, rank;

    public int find(int x) {
        if(x == parent[x]) return x;
        return find(parent[x]);
    }

    public int union(int n1, int n2) {
        int p1 = find(n1), p2 = find(n2);
        if(p1 == p2) return 0;
        if(rank[p1] >= rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return 1;
    }

    public int findCircleNum(int[][] isConnected) {
        int res = isConnected.length;
        parent = new int[res];
        rank = new int[res];
        for(int i = 0; i < res; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for(int i = 0; i < isConnected.length; i++) {
            for(int j = 0; j < isConnected.length; j++) {
                if(i == j || isConnected[i][j] == 0) continue;
                res -= union(i, j);
            }
        }
        return res;
    }
}
