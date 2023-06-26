// url: https://leetcode.com/problems/total-cost-to-hire-k-workers/

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(), pq2 = new PriorityQueue<>();
        int start = candidates-1, end = costs.length-candidates;
        for(int i = 0; i < candidates && i < costs.length; i++) pq1.add(costs[i]);
        for(int i = costs.length-1; i > costs.length-candidates-1 && i >= 0 && i > start; i--) pq2.add(costs[i]);
        long res = 0;
        for(int i = 0; i < k; i++) {
            if(pq1.isEmpty()) res += pq2.remove();
            else if(pq2.isEmpty()) res += pq1.remove();
            else if(pq1.peek() <= pq2.peek()) {
                int val = pq1.remove();
                res += val;
                if(start+1 < end) {
                    start++;
                    pq1.add(costs[start]);
                } 
            } else {
                int val = pq2.remove();
                res += val;
                if(end-1 > start) {
                    end--;
                    pq2.add(costs[end]);
                }
            }
        }
        return res;
    }
}
