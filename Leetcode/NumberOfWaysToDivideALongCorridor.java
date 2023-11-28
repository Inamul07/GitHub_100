// url: https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/

class Solution {
    public int numberOfWays(String corridor) {
        int mod = (int) Math.pow(10, 9) + 7;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < corridor.length(); i++) if(corridor.charAt(i) == 'S') list.add(i);
        if(list.size()%2 != 0 || list.size() == 0) return 0;
        long res = 1;
        for(int i = 1; i < list.size()-1; i+=2) {
            res *= (list.get(i+1) - list.get(i));
            res %= mod;
        }
        return (int) res;
    }
}
