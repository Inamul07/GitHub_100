// url: https://leetcode.com/problems/design-browser-history

class BrowserHistory {

    Stack<String> stack1, stack2;

    public BrowserHistory(String homepage) {
        stack1 = new Stack<>();
        stack1.push(homepage);
        stack2 = new Stack<>();
    }
    
    public void visit(String url) {
        if(!stack2.isEmpty()) stack2.clear();
        stack1.push(url);
    }
    
    public String back(int steps) {
        while(stack1.size() > 1 && steps-- > 0) stack2.push(stack1.pop());
        return stack1.peek();
    }
    
    public String forward(int steps) {
        while(!stack2.isEmpty() && steps-- > 0) stack1.push(stack2.pop());
        return stack1.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
