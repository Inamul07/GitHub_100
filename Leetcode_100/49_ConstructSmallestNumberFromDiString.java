// url: https://leetcode.com/problems/construct-smallest-number-from-di-string/

class Solution {

    char[] res;
    boolean[] set;
    String pattern;

    private boolean backtrack(int num, int idx) {
        if(num < 1) return false;
        res[idx] = (char) ('1' + num - 1);
        set[num] = true;
        if(idx == res.length-1) return true;
        if(pattern.charAt(idx) == 'I') {
            for(int i = num+1; i <= 9; i++) {
                if(set[i]) continue;
                if(backtrack(i, idx+1)) break;
            }
        } else {
            if(set[num-1] || !backtrack(num-1, idx+1)) {
                set[num] = false;
                return false;
            }
        }
        return true;
    }

    public String smallestNumber(String pattern) {
        res = new char[pattern.length()+1];
        set = new boolean[10];
        this.pattern = pattern;
        for(int i = 1; i < 10; i++) {
            if(backtrack(i, 0)) break;
        }
        return new String(res);
    }
}
