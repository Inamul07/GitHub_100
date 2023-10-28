// url: https://leetcode.com/problems/count-vowels-permutation/

class Solution {

    Map<String, Long> map;
    long mod = 1000000007;

    private long dfs(char ch, int currLen, int len) {
        if(currLen == len) return 1;
        if(map.containsKey("" + ch + currLen)) return map.get("" + ch + currLen);
        long val;
        if(ch == 'a') val = dfs('e', currLen+1, len);
        else if(ch == 'e') val = dfs('a', currLen+1, len) + dfs('i', currLen+1, len);
        else if(ch == 'i') val = dfs('a', currLen+1, len) + dfs('e', currLen+1, len) + dfs('o', currLen+1, len) + dfs('u', currLen+1, len);
        else if(ch == 'o') val = dfs('i', currLen+1, len) + dfs('u', currLen+1, len);
        else val = dfs('a', currLen+1, len);
        map.put("" + ch + currLen, val % mod);
        return val % mod;
    }

    public int countVowelPermutation(int n) {
        map = new HashMap<>();
        char[] vows = new char[] {'a', 'e', 'i', 'o', 'u'};
        long res = 0;
        for(char ch: vows) res += dfs(ch, 1, n);
        return (int) (res % mod);
    }
}
