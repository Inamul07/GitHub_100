// url: https://leetcode.com/problems/shifting-letters-ii/
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] difArr = new int[s.length()+1];
        for(int[] shift: shifts) {
            int inc = 1;
            if(shift[2] == 0) inc = -1;
            difArr[shift[1]+1] = (difArr[shift[1]+1] + inc + 26) % 26;
            difArr[shift[0]] = (difArr[shift[0]] + (-1 * inc) + 26) % 26;
        }
        int currDiff = difArr[difArr.length-1];
        char[] str = s.toCharArray();
        for(int i = s.length()-1; i >= 0; i--) {
            int pos = str[i] - 'a';
            pos = (pos + currDiff + 26) % 26;
            str[i] = (char) (pos + 'a');
            currDiff += difArr[i];
        }
        return new String(str);
    }
}
