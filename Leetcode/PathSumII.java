// url: https://leetcode.com/problems/path-sum-ii/

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
    
    List<List<Integer>> paths = new ArrayList<>();
    
    public void allPathSum(TreeNode root, int targetSum, int sum, List<Integer> tempList) {
        
        if(root == null) return;
        sum += root.val;
        
        tempList.add(root.val);
        
        if(root.left == null && root.right == null && sum == targetSum) {
            paths.add(new ArrayList<>(tempList));
        }
        
        allPathSum(root.left, targetSum, sum, tempList);
        allPathSum(root.right, targetSum, sum, tempList);
        
        tempList.remove(tempList.size()-1);
        
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        allPathSum(root, targetSum, 0, new ArrayList<Integer>());
        return paths;
    }
}
