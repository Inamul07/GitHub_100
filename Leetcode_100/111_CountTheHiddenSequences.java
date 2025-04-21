// url: https://leetcode.com/problems/count-the-hidden-sequences/

class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min = 0, max = 0;
        long bound = upper - lower, sum = 0;
        for(int i: differences) {
            sum += i;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
        long res = bound - (max - min) + 1;
        return res >= 0? (int) res: 0;
    }
}
