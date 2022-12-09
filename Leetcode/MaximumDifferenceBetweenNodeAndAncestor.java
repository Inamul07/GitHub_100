// url: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/submissions/857001636/

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

    int maxDiff = 0;

    public void preOrder(TreeNode root, int max, int min) {
        if(root == null) return;
        if(root.val > max) max = root.val;
        if(root.val < min) min = root.val;
        if(root.left == null && root.right == null)
            maxDiff = Math.max(max-min, maxDiff);
        preOrder(root.left, max, min);
        preOrder(root.right, max, min);
    }

    public int maxAncestorDiff(TreeNode root) {
        preOrder(root, -1, Integer.MAX_VALUE);
        return maxDiff;
    }
}
