// url: https://leetcode.com/problems/divide-array-into-equal-pairs/

class Solution {
    public boolean divideArray(int[] nums) {
        int[] arr = new int[501];
        for(int i: nums) arr[i]++;
        for(int i = 0; i < 501; i++) {
            if(arr[i]%2 != 0) return false;
        }
        return true;
    }
}
