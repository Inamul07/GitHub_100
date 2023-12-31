// url: https://leetcode.com/problems/largest-substring-between-two-equal-characters/description/

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                map.get(s.charAt(i)).set(1, i);
            } else {
                map.put(s.charAt(i), new ArrayList<>());
                map.get(s.charAt(i)).add(i);
                map.get(s.charAt(i)).add(Integer.MAX_VALUE);
            }
        }
        int res = -1;
        for(char ch: map.keySet()) {
            if(map.get(ch).get(1) == Integer.MAX_VALUE) continue;
            res = Math.max(map.get(ch).get(1) - map.get(ch).get(0) - 1, res);
        }
        return res;
    }
}
