// url: https://leetcode.com/problems/build-an-array-with-stack-operations/

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int idx = 0;
        for(int i = 1; i <= n; i++) {
            res.add("Push");
            if(target[idx] != i) res.add("Pop");
            else idx++;
            if(idx == target.length) break;
        }
        return res;
    }
}
