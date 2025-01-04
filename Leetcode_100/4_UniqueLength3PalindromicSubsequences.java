// url: https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> left = new HashSet<>();
        Map<Character, Integer> right = new HashMap<>();
        Set<String> set = new HashSet<>();
        int res = 0;
        for(int i = 1; i < s.length(); i++) right.put(s.charAt(i), right.getOrDefault(s.charAt(i), 0) + 1);
        left.add(s.charAt(0));
        for(int i = 1; i < s.length(); i++) {
            right.put(s.charAt(i), right.get(s.charAt(i))-1);
            for(char ch = 'a'; ch <= 'z'; ch++) {
                if(set.contains(s.charAt(i) + "," + ch)) continue;
                if(left.contains(ch) && right.containsKey(ch) && right.get(ch) > 0) {
                    res++;
                    set.add(s.charAt(i) + "," + ch);
                }
            }
            left.add(s.charAt(i));
        }
        return res;
    }
}
