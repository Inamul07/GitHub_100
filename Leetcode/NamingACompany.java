// url: https://leetcode.com/problems/naming-a-company/

class Solution {
    public long distinctNames(String[] ideas) {
        Map<Character, Set<String>> map = new HashMap<>();
        long res = 0;
        // Add the string based on the first character of that string into a set
        for(String s: ideas) {
            map.putIfAbsent(s.charAt(0), new HashSet<String>());
            map.get(s.charAt(0)).add(s.substring(1, s.length()));
        }
        /* 
            For Example: if ideas = ["coffee","donuts","time","toffee"]
            Then, map = {c=[offee], d=[onuts], t=[ime, offee]}

            Now iterate the map with nested loops to find the distinct pairs.
            Both the distinct numbers (When multiplied), gives the valid name for that particular values.
        */
        for(char ch1: map.keySet()) {
            for(char ch2: map.keySet()) {
                if(ch1 == ch2) continue;
                long intersect = 0;
                for(String s: map.get(ch1)) 
                    if(map.get(ch2).contains(s)) intersect++;
                long d1 = map.get(ch1).size() - intersect, d2 = map.get(ch2).size() - intersect;
                res += d1 * d2;
            }
        }
        return res;
    }
}
