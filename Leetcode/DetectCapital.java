// url: https://leetcode.com/problems/detect-capital/

class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.toUpperCase().equals(word) || word.toLowerCase().equals(word))
            return true;
        for(int i = 0; i < word.length(); i++) {
            if(i == 0 && word.charAt(i) < 97) continue;
            else if(word.charAt(i) < 97) return false;
        }
        return true;
    }
}
