// url: https://leetcode.com/problems/string-matching-in-an-array/
class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words.length; j++) {
                if(i == j) continue;
                if(words[i].contains(words[j])) set.add(words[j]);
            }
        }
        return new ArrayList<>(set);
    }
}
