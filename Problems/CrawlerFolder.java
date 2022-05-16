// url: https://leetcode.com/problems/crawler-log-folder/

class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<String>();
        for(String s: logs) {
            if(s.equals("./"))
                continue;
            else if(!stack.isEmpty() && s.equals("../"))
                stack.pop();
            else if(!s.equals("./") && !s.equals("../"))
                stack.push(s);
        }
        return stack.size();
    }
}
