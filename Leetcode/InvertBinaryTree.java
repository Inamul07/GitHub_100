// url: https://leetcode.com/problems/invert-binary-tree/

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

    public void invert(TreeNode root) {
        if(root == null) return;
        if(root.left != null && root.right != null) {
            invert(root.left);
            invert(root.right);
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        } else if(root.left != null) {
            invert(root.left);
            root.right = root.left;
            root.left = null;
        } else if(root.right != null) {
            invert(root.right);
            root.left = root.right;
            root.right = null;
        }
        return;
    }

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
}
