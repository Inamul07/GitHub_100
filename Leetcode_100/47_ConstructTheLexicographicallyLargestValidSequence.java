// url: https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/

/*
 * Spent considerable time to debug the code that runs for some testcases but failed in many (especially in large testcases).
 * Finally, found that the issue was in Line - 17.
 * I failed to check `num != 1` for the second part of that if case.
 */

class Solution {

    int[] res;
    boolean[] visited;
    int n;

    private boolean isValid(int num, int idx) {
        if(idx >= res.length) return true;
        if(res[idx] != 0 || (num != 1 && (idx+num >= res.length || res[idx+num] != 0))) return false;
        res[idx] = num;
        if(num != 1) res[idx+num] = num;
        visited[num] = true;
        int nextIdx = idx;
        while(nextIdx < res.length && res[nextIdx] != 0) nextIdx++;
        if(nextIdx >= res.length) return true;
        boolean ret = false;
        for(int i = n; i > 0; i--) {
            if(visited[i]) continue;
            ret = ret || isValid(i, nextIdx);
        }
        if(!ret) {
            res[idx] = 0;
            if(num != 1) res[idx+num] = 0;
            visited[num] = false;
        }
        return ret;
    }

    public int[] constructDistancedSequence(int n) {
        res = new int[(n*2) - 1];
        visited = new boolean[n+1];
        this.n = n;
        for(int i = n; i > 0; i--) {
            if(isValid(i, 0)) return res;
        }
        return new int[0];
    }
}
