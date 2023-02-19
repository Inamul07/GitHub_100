// url: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int l = 1;
        while(!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int len = q.size();
            for(int i = 0; i < len; i++) {
                TreeNode node = q.remove();
                if(node != null) {
                    level.add(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            if(l%2 == 0) Collections.reverse(level);
            if(!level.isEmpty()) res.add(level);
            l++;
        }
        return res;
    }
}
