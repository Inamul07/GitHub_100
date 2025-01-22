// url: https://leetcode.com/problems/map-of-highest-peak/

class Tuple {
    int i, j;
    int val;

    Tuple(int i, int j, int val) {
        this.i = i;
        this.j = j;
        this.val = val;
    }
}

class Solution {
    public int[][] highestPeak(int[][] grid) {
        Queue<Tuple> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    q.add(new Tuple(i, j, 0));
                    visited.add(i + "," + j);
                    grid[i][j] = 0;
                }
            }
        }
        int[][] coords = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        while(!q.isEmpty()) {
            Tuple node = q.remove();
            for(int[] coord: coords) {
                int ni = node.i + coord[0], nj = node.j + coord[1];
                if(ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[0].length || visited.contains(ni + "," + nj)) continue;
                q.add(new Tuple(ni, nj, node.val + 1));
                visited.add(ni + "," + nj);
                grid[ni][nj] = node.val + 1;
            }
        }
        return grid;
    }
}
