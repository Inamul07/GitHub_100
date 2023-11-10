// url: https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/

class Solution {

    Map<Integer, List<Integer>> map;
    int[] res;
    int idx;

    private void dfs(int node, int parent) {
        for(int child: map.get(node)) {
            if(child == parent) continue;
            res[idx++] = child;
            dfs(child, node);
        }
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        map = new HashMap<>();
        for(int[] pair: adjacentPairs) {
            map.putIfAbsent(pair[0], new ArrayList<>());
            map.putIfAbsent(pair[1], new ArrayList<>());
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }
        int root = -1;
        for(int i: map.keySet()) {
            if(map.get(i).size() == 1) {
                root = i;
                break;
            }
        }
        res = new int[adjacentPairs.length+1];
        idx = 0;
        res[idx++] = root;
        dfs(root, -1);
        return res;
    }
}
