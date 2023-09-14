// url: https://leetcode.com/problems/reconstruct-itinerary/

class Solution {

    Map<String, List<String>> map;
    List<String> res;

    private boolean dfs(String node, int numEdges) {
        if(res.size() == numEdges + 1) return true;
        if(map.get(node).size() == 0) return false;
        List<String> tmp = new ArrayList<>(map.get(node));
        for(int i = 0; i < map.get(node).size(); i++) {
            String child = map.get(node).remove(i);
            res.add(child);
            if(dfs(child, numEdges)) return true;
            map.get(node).add(i, child);
            res.remove(res.size()-1);
        }
        return false;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        for(List<String> ticket: tickets) {
            map.putIfAbsent(ticket.get(0), new ArrayList<>());
            map.putIfAbsent(ticket.get(1), new ArrayList<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        for(String key: map.keySet()) Collections.sort(map.get(key));
        res = new ArrayList<>();
        res.add("JFK");
        dfs("JFK", tickets.size());
        return res;
    }
}
