// url: https://leetcode.com/problems/diagonal-traverse-ii/

class Tuple {
    int num, sum, c;

    Tuple(int num, int sum, int c) {
        this.sum = sum;
        this.num = num;
        this.c = c;
    }
}

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> {
            if(a.sum == b.sum) return a.c - b.c;
            return a.sum-b.sum;
        });
        for(int i = 0; i < nums.size(); i++)
            for(int j = 0; j < nums.get(i).size(); j++) pq.add(new Tuple(nums.get(i).get(j), i+j, j));
        int[] res = new int[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()) res[idx++] = pq.remove().num;
        return res;
    }
}
