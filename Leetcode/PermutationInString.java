// url: https://leetcode.com/problems/permutation-in-string/

class Solution {

    public boolean isZeroes(int[] alpha) {
        for(int i: alpha) if(i != 0) return false;
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s1.equals(s2)) return true;
        int[] alpha = new int[26];
        for(char ch: s1.toCharArray()) alpha[ch-'a']++;
        int start = 0, size = s1.length();
        for(int end = 0; end < s2.length(); end++) {
            alpha[s2.charAt(end)-'a']--;
            if(end - start + 1 >= size) {
                if(isZeroes(alpha)) return true;
                alpha[s2.charAt(start)-'a']++;
                start++;
            }
        }
        return false;
    }
}
