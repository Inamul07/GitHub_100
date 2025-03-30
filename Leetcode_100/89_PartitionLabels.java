// url: https://leetcode.com/problems/partition-labels/

class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) map.put(s.charAt(i), i);
        List<Integer> res = new ArrayList<>();
        int size = 0, end = map.get(s.charAt(0));
        for(int i = 0; i < s.length(); i++) {
            size++;
            end = Math.max(end, map.get(s.charAt(i)));
            if(end == i) {
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}
