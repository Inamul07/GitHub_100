/* Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order. */

class Solution {
    public boolean isLeft(char bracket) {
        if(bracket == '(' || bracket == '[' || bracket == '{')
            return true;
        return false;
    }

    public char reverse(char bracket) {
        if(bracket == '(')
            return ')';
        else if(bracket == '[')
            return ']';
        return '}';
    }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char ch : s.toCharArray()) {
            if(isLeft(ch)) {
                stack.push(ch);
                continue;
            } 
            if(stack.isEmpty() || ch != reverse(stack.pop()))
                    return false;
        }
        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
