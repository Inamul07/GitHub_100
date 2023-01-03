// url: https://leetcode.com/problems/delete-columns-to-make-sorted

class Solution {
    public int minDeletionSize(String[] strs) {
        int res = 0;
        for(int i = 0; i < strs[0].length(); i++) {
            for(int j = 1; j < strs.length; j++) {
                if(strs[j].charAt(i) >= strs[j-1].charAt(i)) continue;
                else {
                    res++;
                    System.out.println(i + " " + res);
                    break;
                }
            }
        }
        return res;
    }
}
