// url: https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/

class Solution {

    private int frequencyFunction(String word) {
        char minChar = 'z';
        int minCharCount = 0;
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) < minChar) {
                minChar = word.charAt(i);
                minCharCount = 1;
            } else if(word.charAt(i) == minChar) minCharCount++;
        }
        return minCharCount;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] queryResults = new int[queries.length], wordResults = new int[words.length];
        for(int i = 0; i < queries.length; i++) queryResults[i] = frequencyFunction(queries[i]);
        for(int i = 0; i < words.length; i++) wordResults[i] = frequencyFunction(words[i]);
        
        int[] res = new int[queries.length];
        for(int i = 0; i < queryResults.length; i++) {
            int curRes = 0;
            for(int j = 0; j < wordResults.length; j++) {
                if(queryResults[i] < wordResults[j]) curRes++;
            }
            res[i] = curRes;
        }
        return res;
    }
}
