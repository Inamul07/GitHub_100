// url: https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/

class Solution {
    public int countGoodSubstrings(String s) {
        int start = 0, count = 0;
        HashSet<Character> set = new HashSet<Character>();
        for(int end = 0; end < s.length(); end++) {
            while(set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(end));
            if(set.size() == 3) {
                count++;
                set.remove(s.charAt(start));
                start++;
            }
        }
        return count;
    }
}
