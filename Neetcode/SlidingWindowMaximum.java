// url: https://leetcode.com/problems/sliding-window-maximum/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max = Integer.MIN_VALUE, start = 0, maxIdx = -1, idx = 0;
        int[] arr = new int[nums.length-k+1];
        for(int end = 0; end < nums.length; end++) {
            if(end >= k) {
                start++;
                if(maxIdx < start) {
                    max = Integer.MIN_VALUE;
                    for(int i = start; i <= end; i++) {
                        if(nums[i] >= max) {
                            max = nums[i];
                            maxIdx = i;
                        }
                    }
                } else if(nums[end] >= max) {
                    max = nums[end];
                    maxIdx = end;
                }
                arr[idx++] = max;
            } else if(nums[end] >= max) {
                max = nums[end];
                maxIdx = end;
            }
            if(end == k-1) arr[idx++] = max;
        }
        return arr;
    }
}