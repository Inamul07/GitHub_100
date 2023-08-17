// url: https://leetcode.com/problems/01-matrix/

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[] {i, j, 0});
                    visited.add(i+","+j);
                }
            }
        }
        while(!q.isEmpty()) {
            int[] node = q.remove();
            mat[node[0]][node[1]] = node[2];
            int[][] coords = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
            for(int[] coord: coords) {
                int nr = node[0] + coord[0], nc = node[1] + coord[1];
                if(nr < 0 || nr >= mat.length || nc < 0 || nc >= mat[0].length || visited.contains(nr+","+nc)) continue;
                q.add(new int[] {nr, nc, node[2] + 1});
                visited.add(nr+","+nc);
            }
        }
        return mat;
    }
}
