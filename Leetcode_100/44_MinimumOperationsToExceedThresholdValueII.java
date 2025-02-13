// url: https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/

class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int res = 0;
        for(int i: nums) pq.add((long) i);
        while(pq.size() > 1 && pq.peek() < (long) k) {
            long num1 = pq.remove(), num2 = pq.remove();
            pq.add(num1 * 2 + num2);
            res++;
        }
        return res;
    }
}
