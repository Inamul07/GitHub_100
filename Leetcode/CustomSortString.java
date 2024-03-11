// url: https://leetcode.com/problems/custom-sort-string/

class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);
        StringBuilder sb = new StringBuilder();
        for(char ch: order.toCharArray()) {
            if(map.containsKey(ch)) {
                sb.append((ch+"").repeat(map.get(ch)));
                map.remove(ch);
            }
        }
        for(char ch: map.keySet()) sb.append((ch+"").repeat(map.get(ch)));
        return sb.toString();
    }
}
