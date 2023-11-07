// url: https://leetcode.com/problems/eliminate-maximum-number-of-monsters/

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        double[] time = new double[dist.length];
        for(int i = 0; i < dist.length; i++) time[i] = (double) dist[i] / speed[i];
        Arrays.sort(time);
        int res = 1;
        for(int i = 1; i < time.length; i++) {
            if(time[i] > i) res++;
            else return res;
        }
        return res;
    }
}
