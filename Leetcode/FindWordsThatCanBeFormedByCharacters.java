// url: https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/

class Solution {
    public int countCharacters(String[] words, String chars) {
        int res = 0;
        int[] alpha = new int[26];
        for(char ch: chars.toCharArray()) alpha[ch-'a']++;
        for(String s: words) {
            int[] tmp = Arrays.copyOf(alpha, 26);
            int flag = 0;
            for(char ch: s.toCharArray()) {
                if(tmp[ch-'a'] == 0) {
                    flag = 1;
                    break;
                }
                tmp[ch-'a']--;
            }
            if(flag == 0) res += s.length();
        }
        return res;
    }
}
