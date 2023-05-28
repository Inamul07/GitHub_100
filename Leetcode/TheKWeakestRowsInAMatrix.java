// url: https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

class Pair {

    int n1, n2;

    Pair(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public String toString() {
        return n1 + "=" + n2 + ", ";
    }
}

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<Pair> list = new ArrayList<>();
        int res[] = new int[k], idx = 0;
        for(int i = 0; i < mat.length; i++) {
            int count = 0;
            for(int j = 0; j < mat[0].length; j++) if(mat[i][j] == 1) count++;
            list.add(new Pair(i, count));
        }
        Collections.sort(list, new Comparator<Pair>() {
            @Override 
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p1.n2, p2.n2);
            }
        });
        for(int i = 0; i < k; i++) res[idx++] = list.get(i).n1;
        return res;
    }
}
