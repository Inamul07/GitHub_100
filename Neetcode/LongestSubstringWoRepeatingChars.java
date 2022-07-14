// url: https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, maxLen = 0;
        Set<Character> set = new HashSet<>();
        for(int end = 0; end < s.length(); end++) {
            while(set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(end));
            maxLen = Math.max(maxLen, set.size());
        }
        
        return maxLen;
    }
}