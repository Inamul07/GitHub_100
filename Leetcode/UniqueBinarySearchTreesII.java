// url: https://leetcode.com/problems/unique-binary-search-trees-ii

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

    private List<TreeNode> generate(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if(left > right) {
            res.add(null);
            return res;
        }
        for(int val = left; val <= right; val++) {
            List<TreeNode> lSubTree = generate(left, val-1), rSubTree = generate(val+1, right);
            for(TreeNode lNode: lSubTree) {
                for(TreeNode rNode: rSubTree) {
                    TreeNode root = new TreeNode(val, lNode, rNode);
                    res.add(root);
                }
            }
        }
        return res;
    }

    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }
}
