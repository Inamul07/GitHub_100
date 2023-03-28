// url: https://leetcode.com/problems/number-of-provinces/

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
