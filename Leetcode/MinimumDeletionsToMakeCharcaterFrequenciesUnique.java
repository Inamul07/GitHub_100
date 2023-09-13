// url: https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/

class Solution {
    public int minDeletions(String s) {
        int res = 0;
        int[] alpha = new int[26];
        for(char ch: s.toCharArray()) alpha[ch-'a']++;
        Arrays.sort(alpha);
        Set<Integer> set = new HashSet<>();
        for(int i = 25; i >= 0; i--) {
            if(alpha[i] == 0) break;
            int num = alpha[i];
            while(set.contains(num) && num > 0) {
                res++;
                num--;
            }
            set.add(num);
        }
        return res;
    }
}
