// url: https://leetcode.com/problems/first-completely-painted-row-or-column/

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, List<Integer>> matrix = new HashMap<>();
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                List<Integer> indices = new ArrayList<>();
                indices.add(i); indices.add(j);
                matrix.put(mat[i][j], indices);
            }
        }
        Map<Integer, Integer> row = new HashMap<>(), col = new HashMap<>();
        int res = 0;
        for(int i: arr) {
            int rowIdx = matrix.get(i).get(0), colIdx = matrix.get(i).get(1);
            row.put(rowIdx, row.getOrDefault(rowIdx, 0) + 1);
            col.put(colIdx, col.getOrDefault(colIdx, 0) + 1);
            if(row.get(rowIdx) == mat[0].length || col.get(colIdx) == mat.length) return res;
            res++;
        }
        return res;
    }
}
