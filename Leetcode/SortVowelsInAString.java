// url: https://leetcode.com/problems/sort-vowels-in-a-string/

class Solution {

    private boolean isVowel(char ch) {
        return "aeiouAEIOU".contains(ch+"");
    }

    public String sortVowels(String s) {
        List<Character> list = new ArrayList<>();
        for(char ch: s.toCharArray()) if(isVowel(ch)) list.add(ch);
        Collections.sort(list);
        System.out.println(list.toString());
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(char ch: s.toCharArray()) {
            if(isVowel(ch)) sb.append(list.get(idx++));
            else sb.append(ch);
        }
        return sb.toString();
    }
}
