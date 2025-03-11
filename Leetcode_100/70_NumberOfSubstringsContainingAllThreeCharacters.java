// url: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

class Solution {
    public int numberOfSubstrings(String s) {
        int[] arr = new int[3];
        int having = 0, start = 0, res = 0;
        for(int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            arr[ch - 'a']++;
            if(arr[ch - 'a'] == 1) having++;
            while(having == 3) {
                res += (s.length() - end);
                char startChar = s.charAt(start);
                arr[startChar - 'a']--;
                if(arr[startChar - 'a'] == 0) having--;
                start++;
            }
        }
        return res;
    }
}
