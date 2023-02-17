// url: https://leetcode.com/problems/day-of-the-year/

class Solution {

    public boolean isLeapYear(int year) {
        if((year%4 == 0 && year%100 != 0) || year%400 == 0) return true;
        return false;
    }

    public int dayOfYear(String date) {
        int year = 0, month = 0, day = 0;
        for(int i = 0; i < date.length(); i++) {
            if(i <= 3) year = year * 10 + (date.charAt(i)-'0');
            if(i >= 5 && i <= 6) month = month * 10 + (date.charAt(i)-'0');
            if(i >= 8) day = day * 10 + (date.charAt(i)-'0');
        }
        int[] days = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(isLeapYear(year)) days[2] = 29;
        for(int i = 1; i < 13; i++) days[i] += days[i-1];
        return days[month-1] + day;
    }
}
