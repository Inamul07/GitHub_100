class Solution {

    private boolean isVowel(char ch) {
        return "aeiou".contains(ch+"");
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] count = new int[words.length+1];
        for(int i = 0; i < words.length; i++) {
            if(isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length()-1))) {
                count[i+1]++;
            }
            count[i+1] += count[i];
        }
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            res[i] = count[queries[i][1]+1] - count[queries[i][0]];
        }
        return res;
    }
}
