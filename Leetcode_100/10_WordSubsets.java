// url: https://leetcode.com/problems/word-subsets/
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        int[] alpha = new int[26];
        for(String word: words2) {
            int[] curr = new int[26];
            for(int i = 0; i < word.length(); i++) {
                curr[word.charAt(i)-'a']++;
            }
            for(int i = 0; i < 26; i++) alpha[i] = Math.max(alpha[i], curr[i]);
        }
        for(String word: words1) {
            int[] curr = new int[26];
            for(int i = 0; i < word.length(); i++) {
                curr[word.charAt(i)-'a']++;
            }
            boolean valid = true;
            for(int i = 0; i < 26; i++) {
                if(curr[i] < alpha[i]) {
                    valid = false;
                    break;
                }
            }
            if(valid) res.add(word);
        }
        return res;
    }
}
