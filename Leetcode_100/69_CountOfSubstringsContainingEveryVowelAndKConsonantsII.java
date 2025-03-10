// url: https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/

class Solution {

    private boolean isVowel(char ch) {
        return "aeiou".contains(ch + "");
    }

    private long countWithAtleastK(String word, int k) {
        Map<Character, Integer> vowelMap = new HashMap<>();
        int vowel = 0, cons = 0, start = 0;
        long res = 0;
        for(int end = 0; end < word.length(); end++) {
            char ch = word.charAt(end);
            if(isVowel(ch)) {
                vowelMap.put(ch, vowelMap.getOrDefault(ch, 0) + 1);
                if(vowelMap.get(ch) == 1) vowel++;
            } else cons++;
            while(start < end && vowel == 5 && cons >= k) {
                res += (word.length() - end);
                char startChar = word.charAt(start);
                if(isVowel(startChar)) {
                    vowelMap.put(startChar, vowelMap.get(startChar) - 1);
                    if(vowelMap.get(startChar) == 0) vowel--;
                } else cons--;
                start++;
            }
        }
        return res;
    }

    public long countOfSubstrings(String word, int k) {
        return countWithAtleastK(word, k) - countWithAtleastK(word, k+1);
    }
}
