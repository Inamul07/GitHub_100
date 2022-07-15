// url: https://leetcode.com/problems/valid-parentheses/

class Solution {
    
    private boolean isLeft(char ch) {
        if(ch == '(' || ch == '{' || ch == '[') return true;
        return false;
    }
    
    private char inv(char ch) {
        if(ch == ')') return '(';
        else if(ch == ']') return '[';
        return '{';
    }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char ch: s.toCharArray()) {
            if(isLeft(ch)) stack.push(ch);
            else {
                if(!stack.isEmpty() && stack.peek() == inv(ch)) stack.pop();
                else return false;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}