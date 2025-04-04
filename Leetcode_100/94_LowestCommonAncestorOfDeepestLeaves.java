// url: https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/

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

class Pair {
    TreeNode node;
    int height;

    Pair(TreeNode node, int height) {
        this.node = node;
        this.height = height;
    }
}

class Solution {

    private Pair postOrder(TreeNode node) {
        if(node == null) return new Pair(null, 0);
        Pair left = postOrder(node.left);
        Pair right = postOrder(node.right);
        if(left.height == right.height) return new Pair(node, left.height+1);
        if(left.height > right.height) return new Pair(left.node, left.height + 1);
        return new Pair(right.node, right.height + 1);
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return postOrder(root).node;
    }
}
