// url: https://leetcode.com/problems/sort-characters-by-frequency/

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> {
           return o2.getValue().compareTo(o1.getValue());
        });
        s = "";
        for(Map.Entry<Character, Integer> entry: list) 
            s += (entry.getKey()+"").repeat(entry.getValue());
        return s;
    }
}
