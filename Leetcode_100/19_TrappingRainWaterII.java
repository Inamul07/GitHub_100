// url: https://leetcode.com/problems/trapping-rain-water-ii/

class Tuple {
    int i, j;
    int height;

    Tuple(int i, int j, int height) {
        this.i = i;
        this.j = j;
        this.height = height;
    }
}

class Solution {
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.height - b.height);
        for(int i = 0; i < heightMap.length; i++) {
            for(int j = 0; j < heightMap[0].length; j++) {
                if(i == 0 || i == heightMap.length-1 || j == 0 || j == heightMap[0].length-1) {
                    pq.add(new Tuple(i, j, heightMap[i][j]));
                    heightMap[i][j] = -1;
                }
            }
        }
        int res = 0;
        int maxHeight = 0;
        int[][] coords = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        while(!pq.isEmpty()) {
            Tuple node = pq.remove();
            int i = node.i, j = node.j;
            maxHeight = Math.max(maxHeight, node.height);
            res += (maxHeight - node.height);
            for(int[] coord: coords) {
                int ni = i + coord[0], nj = j + coord[1];
                if(ni < 0 || ni >= heightMap.length || nj < 0 || nj >= heightMap[0].length || heightMap[ni][nj] == -1) continue;
                pq.add(new Tuple(ni, nj, heightMap[ni][nj]));
                heightMap[ni][nj] = -1;
            }
        }
        return res;
    }
}
