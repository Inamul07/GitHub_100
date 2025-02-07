// url: https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Set<Integer>> colorMap = new HashMap<>();
        Map<Integer, Integer> ballsMap = new HashMap<>();
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int ball = queries[i][0], color = queries[i][1];
            if(ballsMap.containsKey(ball)) {
                int prevColor = ballsMap.get(ball);
                colorMap.get(prevColor).remove(ball);
                if(colorMap.get(prevColor).size() == 0) colorMap.remove(prevColor);
            }
            ballsMap.put(ball, color);
            colorMap.putIfAbsent(color, new HashSet<>());
            colorMap.get(color).add(ball);
            res[i] = colorMap.size();
        }
        return res;
    }
}
