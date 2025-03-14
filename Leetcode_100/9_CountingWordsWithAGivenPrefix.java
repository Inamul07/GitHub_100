// url: https://leetcode.com/problems/counting-words-with-a-given-prefix/
class Solution {
    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for(String word: words) {
            if(word.startsWith(pref)) res++;
        }
        return res;
    }
}
