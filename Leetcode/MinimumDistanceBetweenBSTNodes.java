// url: https://leetcode.com/problems/minimum-distance-between-bst-nodes/

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

    List<Integer> list = new ArrayList<>();
    public void inOrder(TreeNode root) {
        if(root == null) return;
        if(root.left != null) inOrder(root.left);
        list.add(root.val);
        if(root.right != null) inOrder(root.right);
    }

    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < list.size()-1; i++) minVal = Math.min(minVal, list.get(i+1)-list.get(i));
        return minVal;
    }
}
