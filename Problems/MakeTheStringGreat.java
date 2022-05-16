// url: https://leetcode.com/problems/make-the-string-great/

class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(Character ch: s.toCharArray()) {
            if(!stack.isEmpty() && (stack.peek() == ch - 32 || stack.peek() == ch + 32))
                stack.pop();
            else 
                stack.push(ch);
        }
        s = "";
        for(Character ch: stack)
            s += ch;
        return s;
    }
}
