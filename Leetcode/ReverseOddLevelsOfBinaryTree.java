// url: https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/

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

    private void dfs(TreeNode l, TreeNode r, int level) {
        if(l == null) return;
        dfs(l.left, r.right, level + 1);
        dfs(l.right, r.left, level + 1);
        if(level % 2 == 0) {
            l.val = l.val + r.val;
            r.val = l.val - r.val;
            l.val = l.val - r.val;
        }
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        if(root.left == null && root.right == null) return root;
        dfs(root.left, root.right, 0);
        return root;
    }
}
