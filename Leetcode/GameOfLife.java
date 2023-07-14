// url: https://leetcode.com/problems/game-of-life/

class Solution {

    public void copy(int[][] m1, int[][] m2) {
        for(int i = 0; i < m1.length; i++) for(int j = 0; j < m1[i].length; j++) m1[i][j] = m2[i][j];
    }

    public void gameOfLife(int[][] board) {
        int[][] copyBoard = new int[board.length][board[0].length];
        copy(copyBoard, board);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                int[][] coords = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1} ,{1, 0}, {1, 1}};
                int cells = 0;
                for(int[] coord: coords) {
                    int nr = i + coord[0], nc = j + coord[1];
                    if(nr < 0 || nr >= board.length || nc < 0 || nc >= board[i].length) continue;
                    if(board[nr][nc] == 1) cells++;
                }
                if(board[i][j] == 1 && (cells < 2 || cells > 3)) copyBoard[i][j] = 0;
                else if(board[i][j] == 0 && cells == 3) copyBoard[i][j] = 1;
            }
        }
        copy(board, copyBoard);
    }
}
