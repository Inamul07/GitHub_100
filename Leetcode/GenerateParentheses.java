// url: https://leetcode.com/problems/generate-parentheses/

class Solution {

    List<String> res;

    public void solve(String s, int n, int open, int close) {
        if(open < n) solve(s+"(", n, open+1, close);
        if(close < open) solve(s+")", n, open, close+1);
        if(open == n && close == n) res.add(s);
    }

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        solve("", n, 0, 0);
        return res;
    }
}
