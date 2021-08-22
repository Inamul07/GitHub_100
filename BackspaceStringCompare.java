// url: https://leetcode.com/problems/backspace-string-compare/

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<Character>();
        Stack<Character> stack2 = new Stack<Character>();
        for(Character ch: s.toCharArray()) {
            if(ch != '#')
                stack1.push(ch);
            else if(!stack1.isEmpty() && ch == '#' )
                stack1.pop();
        }
        for(Character ch: t.toCharArray()) {
            if(ch != '#')
                stack2.push(ch);
            else if(!stack2.isEmpty() && ch == '#')
                stack2.pop();
        }
        s = "";
        t = "";
        for(Character ch: stack1)
            s += ch;
        for(Character ch: stack2)
            t += ch;
        if(s.equals(t))
            return true;
        return false;
    }
}
