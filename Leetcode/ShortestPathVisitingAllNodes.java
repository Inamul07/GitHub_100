// url: https://leetcode.com/problems/shortest-path-visiting-all-nodes/

class Solution {
    public int shortestPathLength(int[][] graph) {
        if(graph.length == 1) return 0;
        int res = 0;
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        for(int i = 0; i < graph.length; i++) q.add(new int[] {i, 1 << i});
        while(!q.isEmpty()) {
            int size = q.size();
            res++;
            while(size-- > 0) {
                int[] node = q.remove();
                visited.add(node[0] + "," + node[1]);
                for(int child: graph[node[0]]) {
                    int newBitCount = node[1] | (1 << child);
                    if(newBitCount == (1 << graph.length) - 1) return res;
                    if(visited.contains(child + "," + newBitCount)) continue;
                    visited.add(child + "," + newBitCount);
                    q.add(new int[] {child, newBitCount});
                }
            }
        }
        return res;
    }
}

// Reference: https://www.youtube.com/watch?v=1XkMFNvkouo

/*
- ` 1 << i ` is simply but `Math.pow(2, i);`.
- Consider, There are 3 nodes. When we start **BFS** , we start with 001 (i.e) `1 << 0` -> `2^0`.
- When we move to the next node we update the bit count using **OR** operator. 
- For Example: `001 | (1 << 1)` => `001 | 010` => `011`.
- When all the bit turns one `111` * -> (For 3 nodes)* that means that we have visited all the nodes and we return the minimum path.
- The final state is calculated by `(1 << graph.length) - 1` => `(1 << 3) - 1` => `(2^3) - 1` => `7` => *Bit Form* `111`.
*/
