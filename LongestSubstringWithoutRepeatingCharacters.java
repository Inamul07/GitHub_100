// url: https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, count = 0;
        HashSet<Character> set = new HashSet<Character>();
        for(int end = 0; end < s.length(); end++) {
            while(set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(end));
            count = Math.max(count, set.size());
        }
        return count;
    }
}
