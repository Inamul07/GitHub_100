// url: https://leetcode.com/problems/sliding-window-maximum/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] res = new int[nums.length-k+1];
        int idx = 0, start = 0;
        for(int i = 0; i < nums.length; i++) {
            while(!q.isEmpty() && q.peekLast() < nums[i]) q.removeLast();
            q.add(nums[i]);
            if(i >= k-1) {
                res[idx++] = q.peekFirst();
                if(nums[start] == q.peekFirst()) q.removeFirst();
                start++;
            }
        }
        return res;
    }
}
