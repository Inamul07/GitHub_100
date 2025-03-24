// url: https://leetcode.com/problems/count-days-without-meetings/

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int prevEnd = meetings[0][0] - 1;
        for(int i = 0; i < meetings.length; i++) {
            int currStart = Math.max(meetings[i][0], prevEnd + 1);
            int calc = meetings[i][1] - currStart + 1;
            if(calc > 0) days -= calc;
            prevEnd = Math.max(prevEnd, meetings[i][1]);
        }
        return days;
    }
}
