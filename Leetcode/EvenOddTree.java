// url: https://leetcode.com/problems/even-odd-tree/

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
    public boolean isEvenOddTree(TreeNode root) {
        if(root.val%2 == 0) return false;
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int prev = 0;
            int size = q.size();
            if(q.size() == 1 && ((level%2 == 0 && q.peek().val%2 == 0) || (level%2 != 0 && q.peek().val%2 != 0))) return false; 
            while(size-- > 0) {
                TreeNode node = q.remove();
                if(prev == 0) prev = node.val;
                else if((level%2 == 0 && (node.val%2 == 0 || prev >= node.val)) || (level%2 != 0 && (node.val%2 != 0 || prev <= node.val)))
                    return false;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                prev = node.val;
            }
            level++;
        }
        return true;
    }
}
