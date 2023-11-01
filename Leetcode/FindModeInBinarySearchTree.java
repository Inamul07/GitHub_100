// url: https://leetcode.com/problems/find-mode-in-binary-search-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    Map<Integer, Integer> map;

    private void dfs(TreeNode root) {
        if(root == null) return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        dfs(root.left);
        dfs(root.right);
    }

    public int[] findMode(TreeNode root) {
        map = new HashMap<>();
        dfs(root);
        int max = 0;
        List<Integer> list = new ArrayList<>();
        for(int i: map.keySet()) max = Math.max(max, map.get(i));
        for(int i: map.keySet()) if(map.get(i) == max) list.add(i);
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }
}
