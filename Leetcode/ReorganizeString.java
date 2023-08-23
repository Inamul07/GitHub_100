// url: https://leetcode.com/problems/reorganize-string/

class Pair {
    char ch;
    int count;
    Pair(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);
        for(char ch: map.keySet()) pq.add(new Pair(ch, map.get(ch)));
        Pair prev = null;
        String res = "";
        while(!pq.isEmpty() || prev != null) {
            if(pq.isEmpty() && prev != null) return "";
            Pair curr = pq.remove();
            res += curr.ch;
            curr.count -= 1;
            if(prev != null) {
                pq.add(prev);
                prev = null;
            }
            if(curr.count != 0) prev = curr;
        }
        return res;
    }
}
