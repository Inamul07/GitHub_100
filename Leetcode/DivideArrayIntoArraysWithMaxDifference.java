// url: https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int[][] res = new int[nums.length/3][3];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i+=3) {
            if(nums[i+2] - nums[i] <= k) {
                int idx = 0;
                for(int j = i; j <= i+2; j++) res[i/3][idx++] = nums[j];
            } else return new int[0][0];
        }
        return res;
    }
}
