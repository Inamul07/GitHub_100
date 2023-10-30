// url: https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/

class Pair {
    int num, bit;

    Pair(int num, int bit) {
        this.num = num;
        this.bit = bit;
    }
}

class Solution {
    public int[] sortByBits(int[] arr) {
        List<Pair> list = new ArrayList<>();
        for(int i: arr) list.add(new Pair(i, Integer.bitCount(i)));
        Collections.sort(list, (a, b) -> {
            if(a.bit == b.bit) return a.num-b.num;
            return a.bit-b.bit;
        });
        int[] res = new int[arr.length];
        for(int i = 0; i < list.size(); i++) res[i] = list.get(i).num;
        return res;
    }
}
