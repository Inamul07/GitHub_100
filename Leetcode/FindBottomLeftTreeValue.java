// url: https://leetcode.com/problems/find-bottom-left-tree-value/

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

    int max, res;

    private void dfs(TreeNode root, int level) {
        if(root == null) return;
        if(level >= max) {
            res = root.val;
            max = level;
        }
        dfs(root.right, level+1);
        dfs(root.left, level+1);
    }

    public int findBottomLeftValue(TreeNode root) {
        if(root.left == null && root.right == null) return root.val;
        max = -1;
        res = -1;
        dfs(root, 0);
        return res;
    }
}
