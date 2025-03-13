// url: https://leetcode.com/problems/zero-array-transformation-ii/

class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int[] diff = new int[nums.length+1];
        int idx = 0, sum = 0;
        for(int i = 0; i < nums.length; i++) {
            while(sum + diff[i] < nums[i]) {
                if(idx == queries.length) return -1;
                int[] query = queries[idx];
                int l = Math.max(i, query[0]), r = query[1] + 1;
                idx++;
                if(r < i) continue;
                diff[l] += query[2];
                diff[r] -= query[2];
            }
            sum += diff[i];
        }
        return idx;
    }
}
