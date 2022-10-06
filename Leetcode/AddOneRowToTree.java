// url: https://leetcode.com/problems/add-one-row-to-tree/

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
    
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(--depth > 1) {
            int size = q.size();
            while(size > 0) {
                TreeNode node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                size--;
            }
        }
        while(q.size() > 0) {
            TreeNode node = q.poll();
            TreeNode l = node.left, r = node.right;
            node.left = new TreeNode(val);
            node.right = new TreeNode(val);
            node.left.left = l;
            node.right.right = r;
        }
        return root;
    }
}
