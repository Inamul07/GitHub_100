// url: https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/

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
class FindElements {

    Set<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        root.val = 0;
        Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
        set.add(0);
        while(!q.isEmpty()) {
            TreeNode node = q.remove();
            if(node.left != null) {
                node.left.val = (2 * node.val) + 1;
                q.add(node.left);
                set.add(node.left.val);
            }
            if(node.right != null) {
                node.right.val = (2 * node.val) + 2;
                q.add(node.right);
                set.add(node.right.val);
            }
        }
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
