// url: https://www.codingninjas.com/studio/problems/top-view-of-binary-tree_799401

/*********************************************

 Following is the TreeNode class structure

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
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

    public static List<Integer> getTopView(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                Pair p = q.remove();
                if(!map.containsKey(p.y)) map.put(p.y, p.x.data);
                if(p.x.left != null) q.add(new Pair(p.x.left, p.y-1));
                if(p.x.right != null) q.add(new Pair(p.x.right, p.y+1));
            }
        }
        List<Integer> res = new ArrayList<>();
        res.addAll(map.values());
        return res;
    }
}
