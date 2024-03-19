// url: https://leetcode.com/problems/task-scheduler/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        Queue<int[]> q = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: tasks) map.put(ch, map.getOrDefault(ch, 0) + 1);
        for(char ch: map.keySet()) pq.add(map.get(ch));

        int minTime = 0;
        while(!pq.isEmpty() || !q.isEmpty()) {
            if(!q.isEmpty() && q.peek()[1] == minTime) {
                int[] currTask = q.remove();
                pq.add(currTask[0]);
            }
            if(!pq.isEmpty()) {
                int task = pq.remove();
                if(task != 1) q.add(new int[] {task - 1, minTime + n + 1});
            }
            minTime++;
        }

        return minTime;
    }
}
