// url: https://leetcode.com/problems/detonate-the-maximum-bombs/

class Solution {

    Map<Integer, List<Integer>> map;
    int maxVal = 1;

    public double calculateDistance(int x1, int y1, int x2, int y2) {
        double val1 = Math.pow(x1-x2, 2), val2 = Math.pow(y1-y2, 2);
        return Math.sqrt(val1 + val2);
    }

    public void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        Set<Integer> visited = new HashSet<>();
        visited.add(node);
        int val = 1;
        while(!q.isEmpty()) {
            int childNode = q.remove();
            if(!map.containsKey(childNode)) continue;
            for(int i: map.get(childNode)) {
                if(visited.contains(i)) continue;
                q.add(i);
                visited.add(i);
                val++;
            }
        }
        maxVal = Math.max(maxVal, val);
    }

    public int maximumDetonation(int[][] bombs) {
        if(bombs.length == 1) return 1;
        map = new HashMap<>();
        for(int i = 0; i < bombs.length; i++) {
            int[] bomb1 = bombs[i];
            for(int j = 0; j < bombs.length; j++) {
                if(i == j) continue;
                int[] bomb2 = bombs[j];
                double dist = calculateDistance(bomb1[0], bomb1[1], bomb2[0], bomb2[1]);
                if(dist <= (double) bomb1[2]) {
                    map.putIfAbsent(i, new ArrayList<>());
                    map.get(i).add(j);
                }
            }
        }
        for(int i: map.keySet()) bfs(i);
        return maxVal;
    }
}
