// url: https://leetcode.com/problems/removing-stars-from-a-string/

// Brute Force
class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(ch == '*' && !stack.isEmpty()) stack.pop();
            else stack.push(ch);
        }
        String res = "";
        for(char ch: stack) res += ch;
        return res;
    }
}

// Optimized
class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch: s.toCharArray()) {
            if(ch == '*') sb.deleteCharAt(sb.length()-1);
            else sb.append(ch);
        }
        return sb.toString();
    }
}
