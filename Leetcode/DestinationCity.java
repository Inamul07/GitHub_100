// url: https://leetcode.com/problems/destination-city/

class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, List<String>> map = new HashMap<>();
        for(List<String> path: paths) {
            map.putIfAbsent(path.get(0), new ArrayList<>());
            map.putIfAbsent(path.get(1), new ArrayList<>());
            map.get(path.get(0)).add(path.get(1));
        }
        for(String s: map.keySet()) {
            if(map.get(s).size() == 0) return s;
        }
        return "-1";
    }
}
