// url: https://leetcode.com/problems/number-of-flowers-in-full-bloom/

// Brute-Force (TLE)
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        Arrays.sort(flowers, (a, b) -> a[0]-b[0]);
        int[] res = new int[people.length];
        for(int i = 0; i < people.length; i++) {
            for(int[] time: flowers) {
                if(time[0] <= people[i] && time[1] >= people[i]) res[i]++;
                if(time[0] > people[i]) break;
            }
        }
        return res;
    }
}
