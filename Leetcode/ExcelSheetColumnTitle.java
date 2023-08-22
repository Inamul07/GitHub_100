url: https://leetcode.com/problems/excel-sheet-column-title/

class Solution {
    public String convertToTitle(int colNum) {
        StringBuilder sb = new StringBuilder();
        while(colNum > 0) {
            sb.insert(0, (char) ('A' +  ((colNum-1)%26)));
            colNum = (colNum-1) / 26;
        }
        return sb.toString();
    }
}
