// url: https://leetcode.com/problems/last-stone-weight/

class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: stones) pq.add(i);
        while(pq.size() > 1) {
            int x = pq.poll(), y = pq.poll();
            if(x == y) pq.add(0);
            else pq.add(Math.abs(x-y));
        }
        return pq.peek();
    }
}