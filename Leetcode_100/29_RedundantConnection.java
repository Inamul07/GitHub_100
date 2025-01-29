// url: https://leetcode.com/problems/redundant-connection/

class UnionFind {
    int[] parent;
    int[] rank;

    UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public boolean union(int n1, int n2) {
        int p1 = find(n1), p2 = find(n2);
        if(p1 == p2) return false;
        if(rank[p1] >= rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }

    public int find(int n) {
        if(n == parent[n]) return n;
        return find(parent[n]);
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for(int[] edge: edges) {
            if(!uf.union(edge[0]-1, edge[1]-1)) return edge;
        }
        return new int[] {-1, -1};
    }
}
