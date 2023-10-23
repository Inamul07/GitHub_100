// url: https://leetcode.com/problems/validate-binary-tree-nodes/

class Solution {

    Set<Integer> visited;

    private boolean dfs(int root, int[] l, int[] r) {
        if(root == -1) return true;
        if(visited.contains(root)) return false;
        visited.add(root);
        return dfs(l[root], l, r) && dfs(r[root], l, r);
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> hasParent = new HashSet<>();
        for(int i: leftChild) if(i != -1) hasParent.add(i);
        for(int i: rightChild) if(i != -1) hasParent.add(i);
        if(hasParent.size() == n) return false;
        int root = -1;
        for(int i = 0; i < n; i++) {
            if(!hasParent.contains(i)) {
                root = i;
                break;
            }
        }
        visited = new HashSet<>();
        return dfs(root, leftChild, rightChild) && visited.size() == n;
    }
}
