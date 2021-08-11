// url: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(Character ch: s.toCharArray()) {
            if(stack.isEmpty() || stack.peek() != ch)
                stack.push(ch);
            else if(!stack.isEmpty() && stack.peek() == ch)
                stack.pop();
        }
        s = "";
        for(Character i: stack)
            s += i;
        return s;
    }
}
