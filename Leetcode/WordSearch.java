// url: https://leetcode.com/problems/word-search/

class Solution {

    Set<String> visited;

    private boolean search(char[][] board, String word, int r, int c, int currIdx, Set<String> visited) {
        if(currIdx == word.length()) return true;
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length) return false;
        if(visited.contains(r+","+c) || board[r][c] != word.charAt(currIdx)) return false;
        visited.add(r+","+c);
        currIdx++;
        boolean res =   search(board, word, r-1, c, currIdx, visited) ||
                        search(board, word, r, c-1, currIdx, visited) ||
                        search(board, word, r, c+1, currIdx, visited) ||
                        search(board, word, r+1, c, currIdx, visited);
        visited.remove(r + "," + c);
        return res;
    }

    public boolean exist(char[][] board, String word) {
        visited = new HashSet<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(search(board, word, i, j, 0, new HashSet<>())) return true;
            }
        }
        return false;
    }
}
