// url: https://leetcode.com/problems/furthest-point-from-origin/

// Brute Force
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


// O(n)
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l = 0, r = 0, m = 0, res = 0;
        for(int i = 0; i < moves.length(); i++) {
            if(moves.charAt(i) == 'L') l++;
            else if(moves.charAt(i) == 'R') r++;
            else m++;
        }
        res = Math.max(res, Math.abs(l - (r + m)));
        res = Math.max(res, Math.abs(r - (l + m)));
        return res;
    }
}
