// url: https://leetcode.com/problems/pascals-triangle/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < i+1; j++) {
                if(j == 0 || j == i) row.add(1);
                else row.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            res.add(row);
        }
        return res;
    }
}
