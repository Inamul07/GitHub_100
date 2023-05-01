// url: https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/

class Solution {
    public double average(int[] salary) {
        int max = 0, min = Integer.MAX_VALUE, sum = 0;
        for(int i: salary) {
            max = Math.max(max, i);
            min = Math.min(min, i);
            sum += i;
        }
        sum -= (max + min);
        return (double) sum / (salary.length - 2);
    }
}
