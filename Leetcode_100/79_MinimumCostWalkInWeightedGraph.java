// url: https://leetcode.com/problems/minimum-cost-walk-in-weighted-graph/

/*
 * Performing And (&) operation on a number decreases its value.
 * The more we perform the and (&) operation the less the number becomes
*/

class Solution {

    int[] parent;
    int[] rank;
    int[] andArr;

    private void union(int a, int b, int weight) {
        int p1 = find(a), p2 = find(b);
        if(andArr[p1] == -1) andArr[p1] = weight;
        if(andArr[p2] == -1) andArr[p2] = weight;
        if(rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
            andArr[p1] &= (andArr[p2] & weight);
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
            andArr[p2] &= (andArr[p1] & weight);
        }
    }

    private int find(int n) {
        if(parent[n] == n) return n;
        return find(parent[n]);
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        parent = new int[n];
        rank = new int[n];
        andArr = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
            andArr[i] = -1;
        }
        for(int[] edge: edges) union(edge[0], edge[1], edge[2]);
        int[] res = new int[query.length];
        for(int i = 0; i < query.length; i++) {
            int p1 = find(query[i][0]), p2 = find(query[i][1]);
            if(p1 != p2) res[i] = -1;
            else res[i] = (andArr[p1] & andArr[p2]);
        }
        return res;
    }
}
