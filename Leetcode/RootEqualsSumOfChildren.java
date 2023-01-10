// url: https://leetcode.com/problems/root-equals-sum-of-children/

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

    int sum = 0;

    public void preOrder(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) sum += root.val;
        preOrder(root.left);
        preOrder(root.right);
    }

    public boolean checkTree(TreeNode root) {
        preOrder(root);
        return sum == root.val;
    }
}
