// url: https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/

class Solution {

    Map<Integer, List<Integer>> graphMap;
    int[] res;

    public int[] dfs(int node, int parent, String labels) {
        int[] count = new int[26];
        for(int child: graphMap.get(node)) {
            if(child == parent) continue;
            int[] childCount = dfs(child, node, labels);
            for(int i = 0; i < 26; i++) count[i] += childCount[i];
        }
        int val = ++count[labels.charAt(node)-'a'];
        res[node] = val;
        return count;
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        graphMap = new HashMap<>();
        res = new int[n];
        for(int[] edge: edges) {
            graphMap.computeIfAbsent(edge[0], value -> new ArrayList<>()).add(edge[1]);
            graphMap.computeIfAbsent(edge[1], value -> new ArrayList<>()).add(edge[0]);
        }
        int[] count = dfs(0, -1, labels);
        return res;
    }
}
