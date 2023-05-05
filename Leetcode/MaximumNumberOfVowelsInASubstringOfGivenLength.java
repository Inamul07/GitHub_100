// url: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/

class Solution {

    public boolean isVow(char ch) {
        if("aeiou".contains(ch+"")) return true;
        return false;
    }

    public int maxVowels(String s, int k) {
        int start = 0, maxCount = 0, count = 0;
        for(int end = 0; end < s.length(); end++) {
            if(end >= k) {
                if(isVow(s.charAt(start))) count--;
                start++;
            }
            if(isVow(s.charAt(end))) count++;
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
