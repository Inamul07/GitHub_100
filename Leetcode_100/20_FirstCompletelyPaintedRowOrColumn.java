// url: https://leetcode.com/problems/first-completely-painted-row-or-column/

class Pair {
    int i, j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, Pair> map = new HashMap<>();
        Map<String, Integer> rcMap = new HashMap<>();
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                map.put(mat[i][j], new Pair(i, j));
            }
        }
        System.out.println(map.toString());
        int moves = 0;
        for(int i = 0; i < arr.length; i++) {
            Pair idx = map.get(arr[i]);
            String rKey = "r" + idx.i, cKey = "c" + idx.j;
            rcMap.put(rKey, rcMap.getOrDefault(rKey, 0) + 1);
            rcMap.put(cKey, rcMap.getOrDefault(cKey, 0) + 1);
            if(rcMap.get(rKey) == mat[0].length || rcMap.get(cKey) == mat.length) return moves;
            moves++;
        }
        return -1;
    }
}
