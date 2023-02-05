// url: eetcode.com/problems/find-all-anagrams-in-a-string/

class Solution {

    public boolean isZeroes(int[] alpha) {
        for(int i: alpha) if(i != 0) return false;
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int[] alpha = new int[26];
        List<Integer> res = new ArrayList<>();
        if(s.equals(p)) {
            res.add(0);
            return res;
        }
        for(int ch: p.toCharArray()) alpha[ch-'a']++;
        int start = 0, size = p.length();
        for(int end = 0; end < s.length(); end++) {
            alpha[s.charAt(end)-'a']--;
            if(end - start + 1 >= size) {
                if(isZeroes(alpha)) res.add(start);
                alpha[s.charAt(start)-'a']++;
                start++;
            }
        }
        return res;
    }
}
