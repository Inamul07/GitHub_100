// url: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution {

    List<String> res;
    String[] map;

    private void backtrack(int i, String digits, String currStr) {
        if(currStr.length() == digits.length()) {
            res.add(currStr);
            return;
        }
        for(char ch: map[digits.charAt(i)-'0'].toCharArray()) backtrack(i+1, digits, currStr + "" + ch);
    }

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        map = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(digits.isEmpty()) return res;
        backtrack(0, digits, "");
        return res;
    }
}
