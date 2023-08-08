// url: https://leetcode.com/problems/top-k-frequent-words

class Pair {
    String s;
    int n;

    Pair(String s, int n) {
        this.s = s;
        this.n = n;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.n == b.n) return a.s.compareTo(b.s);
            return b.n - a.n;
        });
        List<String> res = new ArrayList<>();
        for(String s: words) map.put(s, map.getOrDefault(s, 0) + 1);
        for(String s: map.keySet()) pq.add(new Pair(s, map.get(s)));
        for(int i = 0; i < k; i++) res.add(pq.remove().s);
        return res;
    }
}
