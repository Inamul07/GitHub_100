// url: https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/

class Solution {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        for(int i = arr.length-1; i >= 0; i--) {
            int tmp = max;
            max = Math.max(max, arr[i]);
            arr[i] = tmp;
        }
        return arr;
    }
}
