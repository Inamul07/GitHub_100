// url: https://leetcode.com/problems/group-anagrams/

// Brute Force (TLE)
class Solution {
    
    public boolean isZero(int[] alpha) {
        for(int i: alpha) if(i != 0) return false;
        return true;
    }
  
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<>();
        int[] flag = new int[strs.length];
        for(int i = 0; i < strs.length; i++) {
            if(flag[i] == 1) continue;
            List<String> grp = new ArrayList<>();
            grp.add(strs[i]);
            int[] alpha = new int[26];
            for(char ch: strs[i].toCharArray()) alpha[ch-'a']++;
            for(int j = i+1; j < strs.length; j++) {
                if(flag[j] == 1) continue;
                int[] copy = Arrays.copyOf(alpha, 26);
                for(char ch: strs[j].toCharArray()) copy[ch-'a']--;
                if(isZero(copy)) {
                    grp.add(strs[j]);
                    flag[j] = 1;
                }
            }
            groups.add(grp);
            flag[i] = 1;
        }
        return groups;
    }
}

// Optimized
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs) {
            char[] chArr = s.toCharArray();
            Arrays.sort(chArr);
            String key = new String(chArr);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
