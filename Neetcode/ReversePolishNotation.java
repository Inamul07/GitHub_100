// url: https://leetcode.com/problems/evaluate-reverse-polish-notation/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s: tokens) {
            int a = 0, b = 0;
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                a = stack.pop();
                b = stack.pop();
            }
            if(s.equals("+")) stack.push(a+b);
            else if(s.equals("-")) stack.push(b-a);
            else if(s.equals("*")) stack.push(a*b);
            else if(s.equals("/")) stack.push(b/a);
            else stack.push(Integer.parseInt(s));
        }
        return stack.peek();
    }
}