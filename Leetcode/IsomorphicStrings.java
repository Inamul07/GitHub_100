// url: https://leetcode.com/problems/isomorphic-strings/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>(), map2 = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            if(map1.containsKey(c1) && map1.get(c1) != c2) return false;
            if(map2.containsKey(c2) && map2.get(c2) != c1) return false;
            map1.put(c1, c2);
            map2.put(c2, c1);
        }
        return true;
    }
}
