// url: https://leetcode.com/problems/max-points-on-a-line/

class Solution {
    public int maxPoints(int[][] points) {
        if(points.length == 1) return 1;
        int max = 0;
        for(int i = 0; i < points.length-1; i++) {
            Map<Double, Integer> map = new HashMap<>();
            Double slope = 0.00;
            int tempMax = 0;
            for(int j = i+1; j < points.length; j++) {
                if(points[j][0]-points[i][0] == 0) slope = Double.MAX_VALUE;
                else slope = ((double) points[j][1]-points[i][1]) / (points[j][0]-points[i][0]);
                if(slope == -0.00) slope = 0.00;
                map.put(slope.doubleValue(), map.getOrDefault(slope.doubleValue(), 0) + 1);
                tempMax = Math.max(tempMax, map.get(slope));
                System.out.println((i == 1)? tempMax: "");
            }
            max = Math.max(max, tempMax+1);
        }
        return max;
    }
}
