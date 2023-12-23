// url: https://leetcode.com/problems/path-crossing/

class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        set.add("0,0");
        int[] pos = new int[] {0, 0};
        for(char d: path.toCharArray()) {
            if(d == 'N') pos[1]++;
            else if(d == 'E') pos[0]++;
            else if(d == 'S') pos[1]--;
            else pos[0]--;
            if(set.contains(pos[0] + "," + pos[1])) return true;
            set.add(pos[0] + "," + pos[1]);
        }
        return false;
    }
}
