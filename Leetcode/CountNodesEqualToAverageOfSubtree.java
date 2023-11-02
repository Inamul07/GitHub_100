// url: https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/

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
    int sum, count;

    Pair(int sum, int count) {
        this.sum = sum;
        this.count = count;
    }
}

class Solution {

    int res;

    private Pair dfs(TreeNode root) {
        if(root == null) return new Pair(0, 0);
        Pair l = dfs(root.left), r = dfs(root.right);
        int sum = root.val + l.sum + r.sum, count = l.count + r.count + 1;
        int avg = sum / count;
        if(avg == root.val) res++;
        return new Pair(sum, count);
    }

    public int averageOfSubtree(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }
}
