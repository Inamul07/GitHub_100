// url: https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/

class Tuple {
    int i, j;
    int weight;

    Tuple(int i, int j, int weight) {
        this.i = i;
        this.j = j;
        this.weight = weight;
    }
}

class Solution {
    public int minCost(int[][] grid) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        Set<String> set = new HashSet<>();
        int[][] coords = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        pq.add(new Tuple(0, 0, 0));
        while(!pq.isEmpty()) {
            Tuple node = pq.remove();
            int i = node.i, j = node.j;
            if(i == grid.length-1 && j == grid[0].length-1) return node.weight;
            if(set.contains(i + "," + j)) continue;
            set.add(i + "," + j);
            for(int idx = 1; idx <= 4; idx++) {
                int deltaWeight = 0;
                if(grid[i][j] != idx) deltaWeight = 1;
                int ni = i + coords[idx-1][0], nj = j + coords[idx-1][1];
                if(ni < 0 || nj < 0 || ni >= grid.length || nj >= grid[0].length || set.contains(ni + "," + nj)) continue;
                pq.add(new Tuple(ni, nj, node.weight + deltaWeight));
            }
        }
        return -1;
    }
}
