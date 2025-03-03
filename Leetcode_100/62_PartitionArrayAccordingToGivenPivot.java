// url: https://leetcode.com/problems/partition-array-according-to-given-pivot/

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        int idx = 0, pivotCount = 0;
        for(int i: nums) {
            if(i == pivot) pivotCount++;
            if(i < pivot) res[idx++] = i;
        }
        while(pivotCount-- > 0) res[idx++] = pivot;
        for(int i: nums) if(i > pivot) res[idx++] = i;
        return res;
    }
}
