// url: https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/

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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        q.add(root);
        int maxLevel = 0, maxSum = Integer.MIN_VALUE, level = 1;
        while(!q.isEmpty()) {
            int size = q.size(), sum = 0;
            while(size-- > 0) {
                TreeNode node = q.remove();
                sum += node.val;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            if(sum > maxSum) {
                maxLevel = level;
                maxSum = sum;
            }
            level++;
        }
        return maxLevel;
    }
}
