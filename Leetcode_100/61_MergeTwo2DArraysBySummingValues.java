// url: https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> resList = new ArrayList<>();
        int idx1 = 0, idx2 = 0;
        while(idx1 < nums1.length && idx2 < nums2.length) {
            if(nums1[idx1][0] == nums2[idx2][0]) {
                resList.add(new int[] {nums1[idx1][0], nums1[idx1][1] + nums2[idx2][1]});
                idx1++;
                idx2++;
            } else if(nums1[idx1][0] < nums2[idx2][0]) {
                resList.add(nums1[idx1]);
                idx1++;
            } else {
                resList.add(nums2[idx2]);
                idx2++;
            }
        }
        while(idx1 < nums1.length) {
            resList.add(nums1[idx1]);
            idx1++;
        }
        while(idx2 < nums2.length) {
            resList.add(nums2[idx2]);
            idx2++;
        }
        int[][] res = new int[resList.size()][2];
        for(int i = 0; i < resList.size(); i++) res[i] = resList.get(i);
        return res;
    }
}
