// url: https://www.codingninjas.com/studio/problems/bottom-view-of-binary-tree_893110

/*********************************************

 Following is the TreeNode class structure

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    
     TreeNode(int val) {
         this.val = val;
         this.left = null;
         this.right = null;
     }
 }

 *********************************************/

import java.util.*;

class Pair {
    TreeNode x;
    int y;

    Pair(TreeNode x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public static List<Integer> bottomView(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                Pair p = q.remove();
                map.put(p.y, p.x.val);
                if(p.x.left != null) q.add(new Pair(p.x.left, p.y-1));
                if(p.x.right != null) q.add(new Pair(p.x.right, p.y+1));
            }
        }
        List<Integer> res = new ArrayList<>();
        res.addAll(map.values());
        return res;
    }
}
