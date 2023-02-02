// url: https://leetcode.com/problems/verifying-an-alien-dictionary/

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length == 1) return true;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++) map.put(order.charAt(i), i+1);
        for(int i = 0; i < words.length-1; i++) {
            if(words[i].equals(words[i+1])) continue;
            int minLen = Math.min(words[i].length(), words[i+1].length());
            for(int j = 0; j < minLen; j++) {
                int o1 = map.get(words[i].charAt(j)), o2 = map.get(words[i+1].charAt(j));
                if(o1 > o2) return false;
                if(o1 < o2) break;
                if(j == minLen-1 && words[i].length() > words[i+1].length()) return false;
            }
        }
        return true;
    }
}
