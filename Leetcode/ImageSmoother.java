// url: https://leetcode.com/problems/image-smoother/

class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[][] res = new int[img.length][img[0].length];
        int[][] coords = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for(int i = 0; i < img.length; i++) {
            for(int j = 0; j < img[0].length; j++) {
                int sum = 0, n = 0;
                for(int[] coord: coords) {
                    int nr = i + coord[0], nc = j + coord[1];
                    if(nr < 0 || nc < 0 || nr >= img.length || nc >= img[0].length) continue;
                    n++;
                    sum += img[nr][nc];
                }
                res[i][j] = (sum / n);
            }
        }
        return res;
    }
}
