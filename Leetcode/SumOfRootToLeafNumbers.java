//url: https://leetcode.com/problems/sum-root-to-leaf-numbers/

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

    public void dfs(TreeNode root, int val) {
        if(root == null) return;
        val = (val*10) + root.val;
        if(root.left == null && root.right == null) sum += val;
        dfs(root.left, val);
        dfs(root.right, val);
    } 

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
}
