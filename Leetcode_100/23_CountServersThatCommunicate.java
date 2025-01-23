// url: https://leetcode.com/problems/count-servers-that-communicate/

class Solution {
    public int countServers(int[][] grid) {
        int res = 0;
        Map<Integer, List<Integer>> rmap = new HashMap<>(), cmap = new HashMap<>();
        Set<String> visited = new HashSet<>();
        for(int i = 0; i < grid.length; i++) {
            rmap.put(i, new ArrayList<>());
            for(int j = 0; j < grid[0].length; j++) {
                cmap.putIfAbsent(j, new ArrayList<>());
                if(grid[i][j] == 1) {
                    rmap.get(i).add(j);
                    cmap.get(j).add(i);
                }
            }
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int components = 1;
                    if(visited.contains(i + "," + j)) continue;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] {i, j});
                    visited.add(i + "," + j);
                    while(!q.isEmpty()) {
                        int[] node = q.remove();
                        for(int col: rmap.get(node[0])) {
                            if(!visited.contains(node[0] + "," + col)) {
                                q.add(new int[] {node[0], col});
                                visited.add(node[0] + "," + col);
                                components++;
                            }
                        }
                        for(int row: cmap.get(node[1])) {
                            if(!visited.contains(row + "," + node[1])) {
                                q.add(new int[] {row, node[1]});
                                visited.add(row + "," + node[1]);
                                components++;
                            }
                        }
                    }
                    if(components != 1) res += components;
                }
            }
        }
        return res;
    }
}
