// url: https://leetcode.com/problems/boats-to-save-people/

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int start = 0, end = people.length-1, res = 0;
        while(start <= end) {
            res++;
            if(start == end) break;
            if(people[start] + people[end] <= limit) start++;
            end--;
        }
        return res;
    }
}
