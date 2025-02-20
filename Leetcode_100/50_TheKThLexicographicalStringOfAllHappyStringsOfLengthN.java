// url: https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/

class Solution {

    char[] res;
    int k;
    int found;

    private void backtrack(char ch, int idx) {
        if((idx > 0 && res[idx-1] == ch) || found == k) return;
        res[idx] = ch;
        if(idx == res.length-1) {
            found++;
            return;
        }
        for(char c = 'a'; c <= 'c'; c++) {
            backtrack(c, idx+1);
        }
    }

    public String getHappyString(int n, int k) {
        res = new char[n];
        this.k = k;
        found = 0;
        for(char ch = 'a'; ch <= 'c'; ch++) {
            backtrack(ch, 0);
        }
        if(found != k) return "";
        return new String(res);
    }
}
