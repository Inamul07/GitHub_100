// url: https://leetcode.com/problems/kth-smallest-element-in-a-bst/

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

    PriorityQueue<Integer> pq;

    private void inorder(TreeNode root) {
        if(root.left != null) inorder(root.left);
        pq.add(root.val);
        if(root.right != null) inorder(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        pq = new PriorityQueue<>();
        inorder(root);
        while(k-- > 1) pq.remove();
        return pq.peek();
    }
}
