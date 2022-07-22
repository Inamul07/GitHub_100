// url: https://leetcode.com/problems/kth-largest-element-in-an-array/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: nums) pq.add(i);
        for(int i = 1; i < k; i++) pq.poll();
        return pq.peek();
    }
}