// url: https://leetcode.com/problems/simplify-path

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String file = "";
        for(char ch: path.toCharArray()) {
            if(ch == '/' && file.isEmpty()) continue;
            else if(ch == '/') {
                if(file.equals("..") && !stack.isEmpty()) stack.pop();
                else if(file.equals(".") || file.equals(".."));
                else stack.push(file);
                file = "";
            } else file += ch;
        }
        if(!file.isEmpty()) {
            if(file.equals("..") && !stack.isEmpty()) stack.pop();
            else if(!file.equals(".") && !file.equals("..")) stack.push(file);
        }
        if(stack.isEmpty()) return "/";
        String res = "";
        for(String s: stack) res += "/" + s;
        return res;
    }
}
