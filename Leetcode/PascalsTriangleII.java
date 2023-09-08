// url: https://leetcode.com/problems/pascals-triangle-ii/

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++) {
            List<Integer> tmp = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) tmp.add(1);
                else tmp.add(row.get(j-1) + row.get(j));
            }
            row = new ArrayList<>(tmp);
        }
        return row;
    }
}
