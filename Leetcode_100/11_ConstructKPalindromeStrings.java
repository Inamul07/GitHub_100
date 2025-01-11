// url: https://leetcode.com/problems/construct-k-palindrome-strings/
class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k) return false;
        int[] alpha = new int[26];
        for(int i = 0; i < s.length(); i++) alpha[s.charAt(i)-'a']++;
        int oddCount = 0;
        for(int i = 0; i < 26; i++) {
            if(alpha[i]%2 != 0) oddCount++;
        }
        if(oddCount > k) return false;
        return true;
    }
}
