// url: https://leetcode.com/problems/minimum-depth-of-binary-tree/

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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                TreeNode node = q.remove();
                if(node.left == null && node.right == null) return depth;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            depth++;
        }
        return depth;
    }
}
