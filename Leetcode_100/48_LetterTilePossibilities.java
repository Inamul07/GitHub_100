// url: https://leetcode.com/problems/letter-tile-possibilities/

class Solution {

    Map<Character, Integer> map;

    private int backtrack() {
        int sum = 0;
        for(char ch: map.keySet()) {
            if(map.get(ch) == 0) continue;
            map.put(ch, map.get(ch)-1);
            sum += 1 + backtrack();
            map.put(ch, map.get(ch) + 1);
        }
        return sum;
    }

    public int numTilePossibilities(String tiles) {
        map = new HashMap<>();
        for(int i = 0; i < tiles.length(); i++) {
            map.put(tiles.charAt(i), map.getOrDefault(tiles.charAt(i), 0) + 1);
        }
        return backtrack();
    }
}
