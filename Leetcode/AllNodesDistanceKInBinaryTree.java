// url: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    Map<TreeNode, List<TreeNode>> map;
    List<Integer> res;

    private void dfsMap(TreeNode root) {
        map.putIfAbsent(root, new ArrayList<>());
        if(root.left != null) {
            map.putIfAbsent(root.left, new ArrayList<>());
            map.get(root).add(root.left);
            map.get(root.left).add(root);
            dfsMap(root.left);
        }
        if(root.right != null) {
            map.putIfAbsent(root.right, new ArrayList<>());
            map.get(root).add(root.right);
            map.get(root.right).add(root);
            dfsMap(root.right);
        }
    }

    private void dfs(TreeNode node, int parent, int level, int k) {
        if(level == k) {
            res.add(node.val);
            return;
        }
        for(TreeNode child: map.get(node)) {
            if(child.val == parent) continue;
            dfs(child, node.val, level+1, k);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        res = new ArrayList<>();
        map = new HashMap<>();
        dfsMap(root);
        dfs(target, -1, 0, k);
        return res;
    }
}
