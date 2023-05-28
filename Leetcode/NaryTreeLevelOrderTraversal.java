// url: https://leetcode.com/problems/n-ary-tree-level-order-traversal/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        List<Integer> fLevel = new ArrayList<>();
        fLevel.add(root.val);
        res.add(fLevel);
        while(!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node node = q.remove();
                for(Node child: node.children) {
                    level.add(child.val);
                    q.add(child);
                }
            }
            if(!level.isEmpty()) res.add(level);
        }
        return res;
    }
}
