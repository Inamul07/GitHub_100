// url: https://leetcode.com/problems/combinations/

class Solution {

    List<List<Integer>> res;

    private void dfs(int i, int n, int k, List<Integer> subset) {
        if(subset.size() == k) {
            res.add(new ArrayList<>(subset));
            return;
        } else if(i > n) return;
        subset.add(i);
        dfs(i+1, n, k, subset);
        subset.remove(subset.size()-1);
        dfs(i+1, n, k, subset);
    }

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        dfs(1, n, k, new ArrayList<>());
        return res;
    }
}
