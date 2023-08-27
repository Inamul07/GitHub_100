// url: https://leetcode.com/problems/furthest-point-from-origin/

class Solution {
    
    Map<String, Integer> map;
    
    private int backtrack(int i, int dist, String moves) {
        if(i == moves.length()) return Math.abs(dist);
        if(map.containsKey(i + "," + dist)) return map.get(i + "," + dist);
        if(moves.charAt(i) == '_') {
            int l = backtrack(i+1, dist-1, moves), r = backtrack(i+1, dist+1, moves);
            map.put(i + "," + dist, Math.max(l, r));
            return Math.max(l, r);
        } else if(moves.charAt(i) == 'L') {
            int res = backtrack(i+1, dist-1, moves);
            map.put(i + "," + dist, res);
        } else {
            int res = backtrack(i+1, dist+1, moves);
            map.put(i + "," + dist, res);
        }
        return map.get(i + "," + dist);
    }
    
    public int furthestDistanceFromOrigin(String moves) {
        if(moves.length() == 1) return 1;
        map = new HashMap<>();
        return backtrack(0, 0, moves);
    }
}
