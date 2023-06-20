// url: https://leetcode.com/problems/validate-binary-search-tree/

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

    private boolean dfs(TreeNode root, long leftBound, long rightBound) {
        if(root == null) return true;
        if(root.val <= leftBound || root.val >= rightBound) return false;
        return dfs(root.left, leftBound, root.val) && dfs(root.right, root.val, rightBound);
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root, (long) Integer.MIN_VALUE - 1, (long) Integer.MAX_VALUE + 1);
    }
}
