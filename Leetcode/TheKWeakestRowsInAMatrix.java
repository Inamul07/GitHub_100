// url: https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

class Solution {

    private int findSoldierCount(int[] nums) {
        if(nums[0] == 0) return 0;
        if(nums[nums.length-1] == 1) return nums.length;
        int start = 0, end = nums.length-1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(mid > 0 && nums[mid] == 0 && nums[mid-1] == 1) return mid;
            if(nums[mid] == 1) start = mid+1;
            else if(nums[mid] == 0) end = mid-1;
        }
        return start;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[1] == b[1]) return a[0]-b[0];
            return a[1]-b[1];
        });
        for(int i = 0; i < mat.length; i++) pq.add(new int[] {i, findSoldierCount(mat[i])});
        int[] res = new int[k];
        for(int i = 0; i < k; i++) res[i] = pq.remove()[0];
        return res;
    }
}
